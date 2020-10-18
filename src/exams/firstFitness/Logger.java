package exams.firstFitness;

import java.util.Arrays;

public class Logger {
    public static void getFitnessInfo(Fitness fitness){ System.out.println(fitness.getFitnessInfo()); }

    public static void getPoolInfo(Fitness fitness){
        System.out.println(fitness.getGymInfo());
    }

    public static void getGymInfo(Fitness fitness){
        System.out.println(fitness.getPoolInfo());
    }

    public static void getFGroupClassInfo(Fitness fitness){
        System.out.println(fitness.getGroupClassInfo());
    }

    public static void getClientInfo(Ticket ticket){
        System.out.println(ticket.toString());
    }
}
