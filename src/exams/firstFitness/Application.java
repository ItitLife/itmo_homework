package exams.firstFitness;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String ans = "";
        Fitness fitness = new Fitness();
        if (LocalTime.now().isAfter(fitness.getClose()) || LocalTime.now().isBefore(fitness.getOpen())) {
            System.out.println("Мы закрыты.");
        } else {
            while (!ans.equals("stop") && (LocalTime.now().isBefore(fitness.getClose()) && LocalTime.now().isAfter(fitness.getOpen()))) {
                for (int i = 0; i < 5; i++) {
                    if (ans.equals("info")) {
                        Logger.getFitnessInfo(fitness);
                        ans = scanner.nextLine();
                    } else if (ans.equals("stop")) break;
                    else {
                        System.out.println("Нажмите Enter, чтобы впустить толстячка");
                        ans = scanner.nextLine();
                        fitness.welcomeClient(Ticket.addTicket());
                    }
                }
                System.out.println("\n____________\nВведите: \nstop, чтобы прекратить" +
                        "\ninfo, чтобы узнать о заполнении фитнес-центра" +
                        "\nпросто нажмите Enter, чтобы продолжить\n____________\n");

            }
            Logger.getFitnessInfo(fitness);
            fitness.closeFitness();
        }
    }
}
