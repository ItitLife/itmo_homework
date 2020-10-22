package lesson11.hw1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class User {
    private String fullName;
    private int salary;
    private Position position;

    public String getFullName() {
        return fullName;
    }

    public int getSalary() {
        return salary;
    }

    public Position getPosition() {
        return position;
    }

    public static void newUser(String string) {
        String[] newUser = string.split("((, )|( )|(: ))+");
        if ((newUser.length != 3 || newUser[2].length() > 1) ||
                (!newUser[2].equalsIgnoreCase("у") && !newUser[2].equalsIgnoreCase("и") && !newUser[2].equalsIgnoreCase("д"))) {
            System.out.println(("Неверно указан пользователь. Пример: имя фамилия У(первая буква должности). Доступные должности: директор,уборщик,инженер"));
            return;
        }
        User user = new User();
        switch (newUser[2].toLowerCase()) {
            case "у":
                user.position = Position.CLEANER;
                user.salary = 1;
                break;
            case "д":
                user.position = Position.DIRECTOR;
                user.salary = 3;
                break;
            case "и":
                user.position = Position.INGINEER;
                user.salary = 2;
                break;
            default:
                System.out.println("Нет подходящей должности");
        }
        user.fullName = newUser[1] + " " + newUser[0];
        Workers.addWorker(user);
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", salary=" + salary +
                ", position=" + position +
                '}';
    }
}
