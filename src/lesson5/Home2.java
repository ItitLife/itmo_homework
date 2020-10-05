package lesson5;

import java.util.Scanner;

/*2. Найти количество вхождений одной строки в другую. <br>
Например, строка "дом" встречается в строке "дом домик домой одомашненный" 4 раза <br>
*/
public class Home2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первую строку(в которой искать): ");
        String firstString = scanner.nextLine();
        System.out.println("Введите вторую строку(что искать): ");
        String secondString = scanner.nextLine();
        String[] count = firstString.split(secondString);
        System.out.println("Количество вхождений: " + (count.length - 1));
    }
}
