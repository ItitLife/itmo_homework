package lesson11.hw1;

import java.util.Arrays;

public class Workers {
    private static User[] cleaners = new User[20];
    private static User[] directors = new User[20];
    private static User[] ingineers = new User[20];

    public static void addWorker(User user) {
        if (user.getPosition().equals(Position.INGINEER)) {
            for (int i = 0; i < ingineers.length; i++) {
                if (ingineers[i] == null) {
                    ingineers[i] = user;
                    break;
                }
            }
        }else if (user.getPosition().equals(Position.DIRECTOR)) {
            for (int i = 0; i < directors.length; i++) {
                if (directors[i] == null) {
                    directors[i] = user;
                    break;
                }
            }
        }else if (user.getPosition().equals(Position.CLEANER)) {
            for (int i = 0; i < cleaners.length; i++) {
                if (cleaners[i] == null) {
                    cleaners[i] = user;
                    break;
                }
            }
        }else throw new IllegalArgumentException("Что-то пошло не так");
        System.out.println(Workers.getInfo());
    }

    public static String getInfo() {
        return "Инженеры: " + Arrays.toString(ingineers) + "\n" +
                "Директора: " + Arrays.toString(directors)+ "\n" +
                "Уборщики: " + Arrays.toString(cleaners);
    }
}
