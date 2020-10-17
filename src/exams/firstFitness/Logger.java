package exams.firstFitness;

import java.util.Arrays;

public class Logger {
    public static void getFitnessInfo(){
        System.out.println(Fitness.getFitnessInfo());
    }

    public static void getPoolInfo(){
        System.out.println(Fitness.getGymInfo());
    }

    public static void getGymInfo(){
        System.out.println(Fitness.getPoolInfo());
    }

    public static void getFGroupClassInfo(){
        System.out.println(Fitness.getGroupClassInfo());
    }

    public static void getClientInfo(Ticket ticket){
        System.out.println(ticket.toString());
    }
}
