package lesson2;
/*Создайте программу, выводящую на экран все неотрицательные элементы последовательности 90 85 80 75 70 65 60 ….
 */
public class Home3 {
    public static void main(String[] args) {
        //byte a = 90;
        for (int a = 90; a>=0; a -=5){
            System.out.println(a);
        }
        /*while (a >= 0) {
            System.out.println(a);
            a -= 5;
        }*/
    }
}
