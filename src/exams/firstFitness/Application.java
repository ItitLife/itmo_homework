package exams.firstFitness;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ans = "";
        while (!ans.equals("stop") || (LocalTime.now().isBefore(Fitness.getClose()) && LocalTime.now().isAfter(Fitness.getOpen()))) {
            for (int i = 0; i < 5; i++) {
                if (ans.equals("info")) {
                    Logger.getFitnessInfo();
                    ans = scanner.nextLine();
                } else if (ans.equals("stop")) break;
                else {
                    System.out.println("Нажмите Enter, чтобы впустить толстячка");
                    ans = scanner.nextLine();
                    Fitness.welcomeClient(Ticket.addTicket());
                }
            }
            System.out.println("\n____________\nВведите: \nstop, чтобы прекратить" +
                    "\ninfo, чтобы узнать о заполнении фитнес-центра" +
                    "\nпросто нажмите Enter, чтобы продолжить\n____________\n");

        }
        Fitness.closeFitness();
        Logger.getFitnessInfo();
    }
}
