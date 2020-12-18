package lesson20;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class SimpleServer {
    // lesson20.properties
    // serverPort=8080
    private Connection connection;

    public static void main(String[] args) {
        SimpleServer server = new SimpleServer();
        try {
            server.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException, ClassNotFoundException {
        Properties properties = new Properties();
        try (InputStream input = SimpleServer.class.getClassLoader().getResourceAsStream("lesson20.properties")) {
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try (ServerSocket serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty("server.port", "800")))) {
            System.out.println("Server was started on port: " + serverSocket.getLocalPort());

            while (true) {
                Socket socket = serverSocket.accept();
                connection = new Connection(socket);
                System.out.println(connection.readMessage());
                connection.sendMessage(Message.getMessage("Server", "catch"));

            }
        }
    }

    public void commandExecutor(Message message) throws IOException {
        if (message.getText().startsWith("/")) {
            switch (message.getText()) {
                case "/help":
                    connection.sendMessage(Message.getMessage("server","/help - список доступных команд\n" +
                            "/count - пользователь хочет узнать количество клиентов сервера, которые подключались к серверу\n" +
                            "/ping - пользователь хочет узнать время за которое сообщение доходит до сервера и возвращается обратно\n" +
                            "/exit - выход из программы"));
                case "/count": connection.sendMessage(Message.getMessage("server", ""));
                case "/ping":
                default:
                    System.out.println("Неизвестная комманда");
            }

        }
    }


}
