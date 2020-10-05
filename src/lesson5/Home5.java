package lesson5;

import java.util.Arrays;
import java.util.Scanner;

/*5. Найдите самое длинное слово в предложении, при условии, что в предложении все слова разной длины <br>
Например, в "в предложении все слова разной длины" самое длинное слово "предложении" */
public class Home5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите предложеие: ");
        String someString = scanner.nextLine();
        String[] splitString = someString.split("((, )|( )|(: ))+");
        int[] amount = new int[splitString.length];
        for (int i = 0; i < amount.length; i++) amount[i] = splitString[i].length();
        int[] max = amount.clone();
        Arrays.sort(max);
        for (int i = 0; i < amount.length; i++) {
            if (max[max.length - 1] == amount[i]) System.out.println("Самое длинное слово: " + splitString[i]);
        }
    }
}
