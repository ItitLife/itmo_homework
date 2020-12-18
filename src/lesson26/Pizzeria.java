package lesson26;

import java.util.concurrent.LinkedBlockingQueue;

public class Pizzeria {
    int tables;
    LinkedBlockingQueue<Order> newOrders = new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Order> processedOrders = new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Order> doneOrders = new LinkedBlockingQueue<>();

}
