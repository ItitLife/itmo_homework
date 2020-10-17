package exams.firstFitness;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {
    private Fatty client;
    private int type; // 0 - Разовый, 1 - дневной, 2 - полный
    private LocalDateTime start;
    private LocalDateTime end;
    private boolean inAction = false;


    public Ticket(Fatty client, int type, LocalDateTime start, LocalDateTime end, boolean inAction) {
        setClient(client);
        setType(type);
        setStart(start);
        setEnd(end);
        setInAction(inAction);
    }

    public Ticket(Fatty client, int type, boolean inAction) {
        setClient(client);
        setType(type);
        setInAction(inAction);
    }

    private void setClient(Fatty client) {
        if (Objects.isNull(client))
            throw new IllegalArgumentException("Клиент должен быть указан");
        this.client = client;
    }

    private void setType(int type) {
        if (type < 0 || type > 2)
            throw new IllegalArgumentException("Тип абонемента должен быть от 0 до 2. 0 - разовый, 1 - дневной, 2 - полный");
        this.type = type;
    }

    private void setStart(LocalDateTime start) {
        /*if (start.isBefore(LocalDateTime.now()))
            throw new IllegalArgumentException("");*/
        this.start = start;
    }

    private void setEnd(LocalDateTime end) {
        if (end.isBefore(start))
            throw new IllegalArgumentException("Дата окончания абонемента не может быть до его начала");
        this.end = end;
    }

    private void setInAction(boolean inAction) {
        this.inAction = inAction;
    }


    public int getType() {
        return type;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public Fatty getClient() {
        return client;
    }

    public static Ticket addTicket() {
        Ticket ticket = new Ticket(Fatty.addFatty(),
                (int) (Math.random() * 3), false);
        ticket.setStart(LocalDateTime.now().minusDays((int) (Math.random() * 2)));
        if (ticket.getType() == 0) {
            ticket.setEnd(ticket.start.plusHours(24));
        } else if (ticket.getType() == 1 || ticket.getType() == 2)
            ticket.setEnd(ticket.start.plusMonths(1));
        return ticket;
    }

    @Override
    public String toString() {
        return  "Посетитель: " +  client.toString() +
                " Тип абонемента: " + type +
                " Зона: " + client.getWish() +
                " Дата и время посещения: " + LocalDateTime.now();
    }
}

