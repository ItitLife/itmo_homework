package lesson5;

import java.util.Arrays;
import java.util.Scanner;

/*4. Заменить все буквы в слове на строчные, а первую букву на заглавную <br>
Например, дано hello, получаем Hello / дано HeLLO, получаем Hello <br>
*/
public class Home4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        StringBuilder someString = new StringBuilder(scanner.nextLine());
        String[] splitString = someString.toString().toLowerCase().split("");
        splitString[0] = splitString[0].toUpperCase();
        someString = new StringBuilder();
        for (String s : splitString) {
            someString.append(s);
        }
        System.out.println(someString);

    }
}
