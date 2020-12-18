package exams.secondChat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private final ConcurrentHashMap<String, Connection> connections = new ConcurrentHashMap<>();
    private final ArrayBlockingQueue<Message> messages = new ArrayBlockingQueue<>(10, true);
    //private ExecutorService readers = Executors.newFixedThreadPool(10);
    private final Writer writer = new Writer();

    public static void main(String[] args) {
        try {
            new Server().start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void start() throws ClassNotFoundException, IOException {
        Properties properties = new Properties();
        try (InputStream input = Server.class.getClassLoader().getResourceAsStream("chat.properties")) {
            properties.load(Objects.requireNonNull(input));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty("server.port", "800")))) {
            System.out.println("Server was started on port: " + serverSocket.getLocalPort());
            new Thread(writer).start();
            while (true) {
                try {
                    Connection connection = new Connection(serverSocket.accept());
                    Message authMessage = connection.readMessage();
                    messages.add(authMessage);
                    connections.putIfAbsent(authMessage.getSender(), connection);
                    new Thread(new Reader(connection)).start();
                    System.out.println("New client: " + authMessage.getSender() + " Connections amount: " + connections.size());
                } catch (IOException e) {
                    System.out.println("Something went wrong");
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private class Reader implements Runnable {
        Connection connection;

        private Reader(Connection connection) {
            this.connection = connection;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    messages.add(connection.readMessage());
                } catch (IOException e) {
                    // e.printStackTrace();
                    String clientName = "";
                    for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                        if (entry.getValue().equals(connection)) {
                            clientName = entry.getKey();
                            break;
                        }
                    }
                    connections.remove(clientName);
                    System.out.println("Connection with [" + clientName + "] was lost");
                    messages.add(new Message(clientName, "[was disconnect]"));
                    System.out.println("Connections amount: " + connections.size());
                    break;
                }
            }
        }
    }

    private class Writer implements Runnable {

        @Override
        public void run() {
            while (true) {
                for (Message message : messages) {
                    if (message != null) {
                        for (Map.Entry<String, Connection> entry : connections.entrySet()) {
                            try {
                                if (!message.getSender().equals(entry.getKey())) entry.getValue().sendMessage(message);
                            } catch (IOException e) {
                                //e.printStackTrace();
                                System.out.println("Exception by sending message to " + entry.getKey());
                            }
                        }
                    }
                    messages.remove(message);
                }
            }
        }
    }
}


