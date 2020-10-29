package lesson12.hw2;

import lesson12.hw1.RandomExceptions;

/*2. Создать массив исключений и заполнить его 9 различными runtime исключениями.
Например,

         try {
             int[] arr = new int[5];
             arr[7] = 12;
         } catch (Exception e) {
             exepArr[0] = e;
         }
и тд
*/
public class ExceptionsArr {
    public static RuntimeException[] reArr = new RuntimeException[9];

    /*public static void main(String[] args) {
        RuntimeException[] exceptions = new RuntimeException[9];
        for (int i = 0; i < exceptions.length; i++) {
            exceptions[i] = RandomExceptions.getSomeRE();
        }
        for (Exception exception : exceptions) {
            System.out.println(exception.toString());
        }
    }*/
    public static void main(String[] args) {
        try {
            int[] ints = new int[1];
            ints[1] = 1;
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e){

        }
    }

    public static void ReArrFill(RuntimeException re) {
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < reArr.length; i++) {
                if (reArr[i] == null) {
                    reArr[i] = re;
                    break;
                }
            }
        }
    }
}
