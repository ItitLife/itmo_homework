package lesson3;

/*2. Создайте массив из чётных чисел [2;20] и выведите элементы массива в консоль в обратном порядке (20 18 16 ... 4 2)
*/
public class Home2 {
    public static void main(String[] args) {
        int intsLenght = 20/2;
        int[] ints = new int[intsLenght];
        for (int i = 0; i < ints.length; i++) ints[i] = i*2 + 2;
        System.out.print("( ");
        for (int i = intsLenght - 1; i >= 0 ; i--) System.out.print(ints[i] + " ");
        System.out.println(")");

    }
}
