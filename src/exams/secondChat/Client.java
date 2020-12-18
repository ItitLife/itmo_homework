package exams.secondChat;

import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Client {
    private String ip;
    private int port;
    private String login;
    private Scanner scanner = new Scanner(System.in);

    private Client() {
        Properties properties = new Properties();
        try (InputStream input = Client.class.getClassLoader().getResourceAsStream("chat.properties")) {
            properties.load(input);
            this.ip = properties.getProperty("server.ip", "192.0.0.1");
            this.port = Integer.parseInt(properties.getProperty("server.port", "800"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            new Client().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception {
        System.out.println("Введите имя нового пользователя: ");
        login = scanner.nextLine();
        while (login == null || login.equals("") || login.length() < 5 ) {
            System.out.println("Имя пользователя должно быть длиннее 4 символов.\nВведите имя нового пользователя: ");
            login = scanner.nextLine();
        }
        String text;
        try (Connection connection = new Connection(new Socket(ip, port))) {
            connection.sendMessage(new Message(login, "[connected]"));
            Thread reader = new Thread(new Reader(connection));
            reader.start();
            System.out.println("Вводите текст сообщения и отправляйте нажатием на Enter: ");
            while (!reader.isInterrupted()) {
                text = scanner.nextLine();
                if (!text.toLowerCase().equals("quit") && connection.isActive())
                    connection.sendMessage(new Message(login, text));
                else {
                    connection.close();
                    break;
                }
            }
        } catch (ConnectException e) {
            // e.printStackTrace();
            System.out.println("Connection problem. Probably server is not ready.");
        }
        System.out.println("You are disconnect, say \"Yes\", if want to retry, or something else to end.");
        if (scanner.nextLine().toLowerCase().equals("yes")) this.start();
    }

    @Override
    public String toString() {
        return "SimpleClient{" +
                "ip='" + ip + '\'' +
                ", port=" + port +
                ", scanner=" + scanner +
                '}';
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
                    Message message = connection.readMessage();
                    //if (!message.getSender().equals(login)) System.out.println(message);
                    System.out.println(message.getSender() + ": " + message.getText());
                } catch (IOException e) {
                    System.out.println("Connection lost");
                    connection.close();
                    // e.printStackTrace();
                    break;
                }
            }
        }
    }
}
