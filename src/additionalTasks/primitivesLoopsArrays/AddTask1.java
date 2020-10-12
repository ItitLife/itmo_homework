package additionalTasks.primitivesLoopsArrays;

import java.util.Scanner;

/*В переменной n хранится натуральное трёхзначное число. Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
 */
public class AddTask1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int someInt = scanner.nextInt(); someInt != 0; someInt /= 10){
            sum += someInt % 10;
        }
        System.out.println(sum);
    }
}
