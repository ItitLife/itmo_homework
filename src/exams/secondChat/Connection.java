package exams.secondChat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean active;


    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream());
        input = new ObjectInputStream(this.socket.getInputStream());
        active = true;
    }

    public boolean isActive() {
        return active;
    }

    public void sendMessage(Message message) throws IOException {
        message.setSendDateTime();
        output.writeObject(message);
        output.flush();

    }

    public synchronized Message readMessage() throws IOException {
        try {
            return (Message) input.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Message was not valid");
            return null;
        }
    }

    @Override
    public void close() {
        active = false;
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
