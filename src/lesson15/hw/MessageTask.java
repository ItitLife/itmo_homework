package lesson15.hw;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        // Ответ в консоль
        MessagePriority[] priorities = MessagePriority.values();
        for (MessagePriority priority : priorities) {
            int count = 0;
            for (Message message : messageList) {
                if (message.getPriority().equals(priority)) {
                    count++;
                }
            }
            System.out.println(priority + ": " + count);
        }


        int[] counts = new int[MessagePriority.values().length];
        for (Message message : messageList) {
            counts[message.getPriority().ordinal()]++;
        }
        /*int[] priorityCount = new int[priorities.length];
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
        for (int i = 0; i < priorities.length; i++) {
            System.out.println(priorities[i] + ": " + priorityCount[i]);
        }*/

    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        HashSet<Integer> codes = new HashSet<>();
        for (Message message : messageList) {
            codes.add(message.getCode());
        }
        for (Integer code : codes) {
            int count = 0;
            for (Message message : messageList) {
                if (code.equals(message.getCode())) { // тут не уверен, может нужно было == вместо equals
                    count++;
                }
            }
            System.out.println(code + ": " + count);
        }
        HashMap<Integer, Integer> messageHashMap = new HashMap<>();
        for (Message message : messageList) {
            messageHashMap.put(message.getCode(), messageHashMap.getOrDefault(message.getCode(), 0) +1);
        }
        for (Message message : messageList) {
            if (messageHashMap.containsKey(message.getCode())){
                messageHashMap.put(message.getCode(), messageHashMap.get(message.getCode()) +1 );
            }else {
                messageHashMap.put(message.getCode(), 1);
            }
        }
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        /*HashSet<Message> messageHashSet = new HashSet<>(messageList);
        System.out.println("Уникальных: " + messageHashSet.size());*/
        System.out.println("Уникальных: " + new HashSet<>(messageList).size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        /*LinkedHashSet linkedHashSet = new LinkedHashSet(messageList);
        messageList = new LinkedList<>(linkedHashSet);
        return messageList;*/
        return new ArrayList<>(new LinkedHashSet<>(messageList));
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next().getPriority().equals(priority)) {
                iterator.remove();
            }
        }
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        Iterator<Message> iterator = messageList.listIterator();
        while (iterator.hasNext()) {
            if (!iterator.next().getPriority().equals(priority)) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> messages = MessageGenerator.generate(100);
        countEachCode(messages);
        countEachPriority(messages);
        uniqueMessageCount(messages);
        List<Message> uniqueMessagesInOriginalOrder = new ArrayList<>(uniqueMessagesInOriginalOrder(messages));
        List<Message> uniqueMessages = new ArrayList<>(new HashSet<>(messages));
        System.out.println(uniqueMessages.equals(uniqueMessagesInOriginalOrder));
        removeEach(messages, MessagePriority.HIGH);
        countEachPriority(messages);
        removeOther(messages, MessagePriority.LOW);
        countEachPriority(messages);
    }
}
