package lesson2;

import java.util.Scanner;

/*Программа загадывает число в диапазоне [1;9]
Пользователь вводит число с клавиатуры
Программа в зависимости от введенного числа выводит в консоль следующее:
"загаданное число больше"
"загаданное число меньше"
"Вы угадали" (программа завершает работу)
если введен 0, выводит "выход из программы" (программа завершает работу)*/
public class Home6 {
    public static void main(String[] args) {
        int randomNumber = 1 + (int) (Math.random() * 8);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Испытай удачу: ");
        int userNumber = scanner.nextInt();
        while (true) {
            if (userNumber == 0) {
                System.out.println("Выход из программы.");
                break;
            } else if (userNumber == randomNumber) {
                System.out.println("Вы угадали!");
                break;
            } else if (userNumber < randomNumber) {
                System.out.println("Загаданное число больше");
                System.out.println("Попробуй ещё раз: ");
                userNumber = scanner.nextInt();
            } else if (userNumber > randomNumber) {
                System.out.println("Загаданное число меньше");
                System.out.println("Попробуй ещё раз: ");
                userNumber = scanner.nextInt();
            }
        }
    }
}

