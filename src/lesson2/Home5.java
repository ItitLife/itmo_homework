package lesson2;

import java.util.Scanner;

/*Задача на синтаксис switch. Дана целочисленная переменная (номер билета от пользователя):
если ее значение 111, 222 или 333 сообщить пользователю, что он получит "Книгу",
если ее значение 444 или 555 сообщить пользователю, что он получит "Телефон",
если ее значение 777 сообщить пользователю, что он получит "Ноутбук".
В остальных случаях сообщить, что приза нет.
*/
public class Home5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер: ");
        int userNumber = scanner.nextInt();
        System.out.print("Вы получите: ");
        switch (userNumber) {
            case 111:
            case 222:
            case 333:
                System.out.println("Книгу");
                break;
            case 444:
            case 555:
                System.out.println("Телефон");
                break;
            case 777:
                System.out.println("Ноутбук");
                break;
            default:
                System.out.println("ничего");
                System.out.println("Приза нет.");

        }
    }
}
