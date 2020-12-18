package lesson20;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class SimpleClient {
    private String ip;
    private int port;
    private Scanner scanner;

    public SimpleClient() {
        Properties properties = new Properties();
        try (InputStream input = SimpleServer.class.getClassLoader().getResourceAsStream("lesson20.properties")) {
            properties.load(input);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        this.ip = properties.getProperty("server.ip", "192.0.0.1");
        this.port = Integer.parseInt(properties.getProperty("server.port", "800"));
    }

    public void start() throws Exception {
        scanner = new Scanner(System.in);
        System.out.println("Введите имя нового пользователя: ");
        String senderName = scanner.nextLine();
        String message;
        while (true) {
            System.out.println("Введите текст сообщения: ");
            message = scanner.nextLine();
            sendMessage(Message.getMessage(senderName, message));
        }
    }

    private void sendMessage(Message message) throws Exception {
        try (Connection connection = new Connection(new Socket(ip, port))) {
            message.setSendDateTime();
            connection.sendMessage(message);
            Message fromServer = connection.readMessage();
            System.out.println("от сервера: " + fromServer);
        }
    }

    public static void main(String[] args) {
        try {
            new SimpleClient().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
