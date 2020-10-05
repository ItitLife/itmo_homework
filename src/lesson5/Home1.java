package lesson5;

import java.util.Arrays;
import java.util.Scanner;

/*1. Заполнить массив <br>
Задать массив на N слов. <br>
В цикле считывать с консоли слова (scanner.nextLine()), и
добавлять их в массив (добавлять новое слово в массив можно только, если в нем его еще нет).
В итоге в массиве будут только уникальные слова. <br>
Выход их программы по слову exit (его в массив не добавлять) или если массив заполнен <br>
Перед завершением программы, вывести получившийся массив в консоль <br>
*/
public class Home1 {
    public static void main(String[] args) {
        int n = 5;
        String[] words = new String[n];
        Scanner scanner = new Scanner(System.in);
        n = 0;
        do {
            System.out.println("Введите слово: ");
            String newWord = scanner.nextLine();
            boolean was = false;
            if (!newWord.equals("exit")) {
                for (int i = 0; i < words.length; i++) {
                    if (newWord.equals(words[i])) {
                        System.out.println("Повтор");
                        was = true;
                        break;
                    }
                }
                if (!was) {
                    words[n] = newWord;
                    n++;
                }
            } else break;
        } while (n < words.length);
        System.out.println(Arrays.toString(words));
    }
}
