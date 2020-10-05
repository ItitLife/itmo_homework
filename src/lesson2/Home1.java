package lesson2;

import java.util.Scanner;

// Пользователь загадывает число от 1 до 100
// программа пытается угадать
// программа может задать следующие вопросы:
// Число равно X?
// Число больше X?
// Число меньше X?
// 0 - нет / 1 - да
// бинарный поиск
/*Пользователь! загадывает число в диапазоне от [1 до 100], программа пытается его угадать (используйте метод бинарного поиска - деление отрезка на 2).
Программа может задавать пользователю вопросы: Число равно X? / Число больше X? / Число меньше X? и в зависимоти от ответа пользователя принимать решения.
PS: вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА*/
public class Home1 {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int answer;
        int first = 1;
        int last = 101;
        int guess = (last - first) / 2;
        System.out.println("Загадайте число.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        do {
            System.out.println("Загаданное число равно " + guess + " ?");
            answer = scanner.nextInt();
            if (answer == 0) {
                System.out.println("Загаданное число больше " + guess + " ?");
                answer = scanner.nextInt();
                if (answer == 1) {
                    first = guess;
                    guess = guess + (last - first) / 2;
                    answer = 0;
                } else if (answer == 0) {
                    last = guess;
                    guess = guess - (last - first) / 2;
                } else {
                    System.out.println("0 - нет, 1 - да");
                }
            } else if (answer < 0 || answer > 1) {
                System.out.println("0 - нет, 1 - да");
            }

        } while (answer != 1);
        System.out.println("Nice!");
    }
}
