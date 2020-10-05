package lesson3;

import java.util.Arrays;

/*1. Заполните массив на N элементов случайным целыми числами и выведете максимальное, минимальное и среднее значение
*/
public class Home1 {
    public static void main(String[] args) {
        int randomLength = 1 + (int) (Math.random() * 100);
        int[] randomArray = new int[randomLength];
        for (int i = 0; i < randomArray.length; i++) randomArray[i] = 1 + (int) (Math.random() * 1000);
        int avg = 0;
        for (int value : randomArray) avg += value;
        Arrays.sort(randomArray);
        System.out.println("min = " + randomArray[0]);
        System.out.println("avg = " + avg/randomArray.length);
        System.out.println("max = " + randomArray[randomLength-1]);
    }
}
