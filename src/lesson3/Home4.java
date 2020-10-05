package lesson3;

import java.util.Arrays;

/*4. Разобрать методы класса Arrays: compare, compareUnsigned, mismatch*/
public class Home4 {
    public static void main(String[] args) {
        int[] first = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] second = new int[]{1, 2, 3, 4, 5, -6, 7};
        int[] third = new int[]{432, 34, 234, 267};
        int[] fourth = new int[]{1, 2, 3, 9, 5, 6, 7};
        System.out.println(Arrays.compare(first,second));
        System.out.println(Arrays.equals(first,second));
        System.out.println(Arrays.compareUnsigned(first,second));
        System.out.println(Arrays.mismatch(first,second));
        Arrays.sort(third);
        System.out.println(Arrays.binarySearch(third, 234));
    }
}
