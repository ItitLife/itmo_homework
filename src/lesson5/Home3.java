package lesson5;

import java.util.Arrays;
import java.util.Scanner;

/*3. Написать функцию, которая проверяет, является ли строка палиндромом. <br>
Палиндром — это число, буквосочетание, слово или текст, которые одинаково читаются по буквам или по словам как слева направо, так и справа налево. <br>
Например, 202 - палиндром / fafaf - палиндром / а роза упала на лапу Азора - палиндром <br>
*/
public class Home3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку для проверки на палиндромность): ");
        String palindrom = scanner.nextLine();
        String[] palArray = palindrom.toLowerCase().split("");
        String[] yarrAlap = new String[palArray.length];
        for (int i = 0; i < yarrAlap.length; i++) yarrAlap[i] = palArray[palArray.length - 1 - i];
        //System.out.println(Arrays.toString(palArray));
        //System.out.println(Arrays.toString(yarrAlap));
        if (Arrays.equals(palArray, yarrAlap)) System.out.println("Это он.");
        else System.out.println("Это не он.");
    }

}
