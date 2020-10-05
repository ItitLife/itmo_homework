package lesson2;

/*Написать код, который будет проверять попало ли случайно сгенерированное целое число из отрезка [10;500] в интервал (25;200) и выводить результат в консоль.
Примеры работы программы:
Число 345 не содержится в интервале (25;200)
Число 110 содержится в интервале (25;200)
*/
public class Home4 {
    public static void main(String[] args) {
        //int first = 10, last = 500;
        //int random = first + (int) (Math.random() * (last - first));
        int random = 10 + (int) (Math.random() * (500 - 10 + 1)); // прочитать про Math.random
        if (random <= 200 && random >= 25) {
            System.out.println("Число " + random + " содержится в интервале (25;200)");
        } else {
            System.out.println("Число " + random + " не содержится в интервале (25;200)");
        }
    }
}
