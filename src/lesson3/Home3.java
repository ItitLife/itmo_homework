package lesson3;

import java.util.Arrays;

/*3. Создайте массив из 11 случайных целых чисел из отрезка [-1;1], выведите массив в консоль.
Определите какой элемент встречается в массиве чаще всего и выведите информацию об этом в консоль.
Если два каких-то элемента встречаются одинаковое количество раз, то не выводите ничего.
*/
public class Home3 {
    public static void main(String[] args) {
        int amount = 11, min = -1, max = 1;
        int[] ints = new int[amount], counts = new int[max - min + 1], index = new int[max - min + 1];
        for (int i = 0; i < index.length; i++) index[i] = min + i;
        for (int i = 0; i < ints.length; i++) ints[i] = min + (int) (Math.random() * (max - min + 1));
        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(index));
        for (int i = 0; i < counts.length; i++) {
            for (int j = 0; j < ints.length; j++) if (ints[j] == index[i]) counts[i]++;
        }
        System.out.println(Arrays.toString(counts));
        int[] countsForSort = new int[max - min + 1];
        for (int i = 0; i < countsForSort.length; i++) countsForSort[i] = counts[i]; // clone
        Arrays.sort(countsForSort);
        System.out.println(Arrays.toString(countsForSort));
        boolean pair = false;
        for (int i = 0; i < countsForSort.length - 1; i++) {
            if (countsForSort[i] == countsForSort[i + 1]) pair = true;
        }
        if (!pair) {
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == countsForSort[max - min]) System.out.println(index[i] + ": " + counts[i]);
            }
        }
        /*
        int[] ints = new int[11];
        for (int i = 0; i < ints.length; i++) ints[i] = (int) (Math.random() * 4 - 2);
        System.out.println(Arrays.toString(ints));
        int minusOne = 0, zero = 0, one = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == -1) minusOne++;
            else if (ints[i] == 0) zero++;
            else one++;
        }
        int[] ints1 = new int[10];
        System.out.println(Arrays.compare(ints, ints1));
        if (!(minusOne == zero || minusOne == one || zero == one)) {
            if (minusOne > zero && minusOne > one) System.out.println("-1: " + minusOne);
            else if (zero > minusOne && zero > one) System.out.println("0: " + zero);
            else System.out.println("1: " + one);
        }*/

    }
}
