package exams.firstFitness;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Fitness {
    private static final LocalTime open = LocalTime.of(0, 00);
    private static final LocalTime close = LocalTime.of(23, 59);

    private static Ticket[] pool = new Ticket[20];
    private static Ticket[] gym = new Ticket[20];
    private static Ticket[] groupClass = new Ticket[20];


    public static void welcomeClient(Ticket ticket) {
        if (LocalTime.now().isBefore(close) && LocalTime.now().isAfter(open)) {
            if (LocalDateTime.now().isAfter(ticket.getStart()) && LocalDateTime.now().isBefore(ticket.getEnd())) {
                if (ticket.getType() == 1 && LocalTime.now().isAfter(LocalTime.of(16, 00))) {
                    System.out.println("Дневной абонемент не позволяет посещать фитнес-центр после 16:00");
                } else {
                    if (ticket.getClient().getWish() != null) {
                        if (ticket.getClient().getWish().equals("pool"))
                            poolValidator(ticket);
                        if (ticket.getClient().getWish().equals("gym"))
                            gymValidator(ticket);
                        if (ticket.getClient().getWish().equals("groupClass"))
                            groupClassValidator(ticket);
                    }
                }
            } else System.out.println("Ваш абонемент не действителен.");
        } else System.out.println("Мы закрыты");
    }

    private static void poolValidator(Ticket ticket) {
        if (ticket.getType() == 0 || ticket.getType() == 2) {
            for (int i = 0; i < pool.length; i++) {
                if (pool[i] == null) {
                    pool[i] = ticket;
                    Logger.getClientInfo(ticket);
                    //System.out.println(ticket.getClient().toString() + " плывёт");
                    return;
                }
            }
            System.out.println("В бассейне нет мест");
            System.out.println(Arrays.toString(pool));
            return;

        } else System.out.println("Ваш абонемент не позволяет посещать бассейн");
    }

    private static void groupClassValidator(Ticket ticket) {
        if (ticket.getType() == 1 || ticket.getType() == 2) {
            for (int i = 0; i < groupClass.length; i++) {
                if (groupClass[i] == null) {
                    groupClass[i] = ticket;
                    Logger.getClientInfo(ticket);
                    //System.out.println(ticket.getClient().toString() + " тренируется в группе");
                    return;
                }
            }
            System.out.println("На групповых занятиях нет мест");
            System.out.println(Arrays.toString(groupClass));
            return;
        } else System.out.println("Ваш абонемент не позволяет посещать групповые занятия");
    }

    private static void gymValidator(Ticket ticket) {
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] == null) {
                gym[i] = ticket;
                Logger.getClientInfo(ticket);
                //System.out.println(ticket.getClient().toString() + " тягает железо");
                return;
            }
        }
        System.out.println("В тренажерном зале нет мест");
        System.out.println(Arrays.toString(gym));
        return;

    }

    public static void closeFitness() {
        pool = new Ticket[20];
        gym = new Ticket[20];
        groupClass = new Ticket[20];
    }

    public static String getFitnessInfo() {
        String str = "Тренажерный зал: " + Arrays.toString(gym) + "\n"
                + "Бассейн: " + Arrays.toString(pool) + "\n"
                + "Групповые занятия" + Arrays.toString(groupClass);
        return str;
    }

    public static String getGymInfo() {
        String str = "Тренажерный зал: " + Arrays.toString(gym);
        return str;
    }

    public static String getPoolInfo() {
        String str = "Бассейн: " + Arrays.toString(pool);
        return str;
    }

    public static String getGroupClassInfo() {
        String str = "Групповые занятия" + Arrays.toString(groupClass);
        return str;
    }
}


