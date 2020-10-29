package lesson15.hw;

import java.util.HashSet;
import java.util.List;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int[] priorityCount = new int[4];
        for (Message message : messageList) {
            if (message.getPriority().equals(MessagePriority.LOW)) {
                priorityCount[0]++;
                break;
            }
            if (message.getPriority().equals(MessagePriority.MEDIUM)) {
                priorityCount[0]++;
                break;
            }
            if (message.getPriority().equals(MessagePriority.HIGH)) {
                priorityCount[0]++;
                break;
            }
            if (message.getPriority().equals(MessagePriority.URGENT)) priorityCount[0]++;
        }
        System.out.println(MessagePriority.LOW + ": " + priorityCount[0]);
        System.out.println(MessagePriority.MEDIUM + ": " + priorityCount[1]);
        System.out.println(MessagePriority.HIGH + ": " + priorityCount[2]);
        System.out.println(MessagePriority.URGENT + ": " + priorityCount[3]);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль

    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
    }

    public static void main(String[] args) {
        // вызов методов

    }
}
