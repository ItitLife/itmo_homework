package lesson2;

/*Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
 */
public class Home2 {
    public static void main(String[] args) {
        for (int a = 2, cont = 1; cont <= 20; cont++, a *= 2) {
            System.out.println(cont + ": " + a);
        }
    }
}
