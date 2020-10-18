package exams.firstFitness;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Fitness {
    private final LocalTime open = LocalTime.of(8, 00);
    private final LocalTime close = LocalTime.of(22, 00);
    private final LocalTime closeForDailyTicket = LocalTime.of(16, 00);
    DateTimeFormatter frm = DateTimeFormatter.ofPattern("YYYY.MM.dd HH:mm");

    private final Ticket[] pool = new Ticket[20];
    private final Ticket[] gym = new Ticket[20];
    private final Ticket[] groupClass = new Ticket[20];


    public LocalTime getOpen() {
        return open;
    }

    public LocalTime getClose() {
        return close;
    }

    public void welcomeClient(Ticket ticket) {
        if (LocalTime.now().isBefore(close) && LocalTime.now().isAfter(open)) {
            if (LocalDateTime.now().isAfter(ticket.getStart()) && LocalDateTime.now().isBefore(ticket.getEnd())) {
                if (ticket.getType() == 1 && LocalTime.now().isAfter(closeForDailyTicket)) {
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
            } else {
                System.out.println("Ваш абонемент не действителен.");
                System.out.println("Дата начала абонемента: " + ticket.getStart().format(frm) + " / Дата его окончания: " + ticket.getEnd().format(frm));
            }
        } else System.out.println("Мы закрыты");
    }

    private void poolValidator(Ticket ticket) {
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
            //System.out.println(Arrays.toString(pool));
            return;

        } else System.out.println("Ваш абонемент не позволяет посещать бассейн");
    }

    private void groupClassValidator(Ticket ticket) {
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
            //System.out.println(Arrays.toString(groupClass));
            return;
        } else System.out.println("Ваш абонемент не позволяет посещать групповые занятия");
    }

    private void gymValidator(Ticket ticket) {
        for (int i = 0; i < gym.length; i++) {
            if (gym[i] == null) {
                gym[i] = ticket;
                Logger.getClientInfo(ticket);
                //System.out.println(ticket.getClient().toString() + " тягает железо");
                return;
            }
        }
        System.out.println("В тренажерном зале нет мест");
        //System.out.println(Arrays.toString(gym));
        return;
    }

    public void closeFitness() {
        Arrays.fill(pool, null);
        Arrays.fill(gym, null);
        Arrays.fill(groupClass, null);
        // подсказка среды. Я Arrays.fill() раньше не использовал)
    }

    public String getFitnessInfo() {
        return "Тренажерный зал: " + Arrays.toString(gym) + "\n"
                + "Бассейн: " + Arrays.toString(pool) + "\n"
                + "Групповые занятия" + Arrays.toString(groupClass);
    }

    public String getGymInfo() {
        return "Тренажерный зал: " + Arrays.toString(gym);
    }

    public String getPoolInfo() {
        return "Бассейн: " + Arrays.toString(pool);
    }

    public String getGroupClassInfo() {
        return "Групповые занятия" + Arrays.toString(groupClass);
    }
}


