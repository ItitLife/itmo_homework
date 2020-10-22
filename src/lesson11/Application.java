package lesson11;

import lesson11.hw1.User;
import lesson11.hw2.Planets;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //1
        Scanner scanner = new Scanner(System.in);
        String string;
        do {
            System.out.println("Введите Имя Фамилию и первую букву должности нового сотрудника через пробел: ");
            User.newUser(scanner.nextLine());
            System.out.println("Нажмите enter, чтобы повторить или \"хватит\", чтобы хватит");
            string = scanner.nextLine();
        } while (!"хватит".equalsIgnoreCase(string));
        //2
        //System.out.println("Венера: " + Planets.VENUS.getParameters());
    }
}
