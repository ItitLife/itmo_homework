package additionalTasks.primitivesLoopsArrays;

import java.util.Scanner;

/*Создать программу, выводящую на экран ближайшее к 10 из двух чисел, записанных в переменные m и n.
Например, среди чисел 8,5 и 11,45 ближайшее к десяти 11,45.*/
public class AddTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        double first = scanner.nextDouble();
        System.out.println("Введите второе число: ");
        double second = scanner.nextDouble();
        System.out.print("Ближе к 10 число: ");
        if (Math.abs(10 - first) > Math.abs(10 - second)) {
            System.out.println(second);
        } else if (Math.abs(10 - first) < Math.abs(10 - second)) {
            System.out.println(first);
        } else {
            System.out.println("серьёзно?");
        }

        System.out.println();
    }
}
