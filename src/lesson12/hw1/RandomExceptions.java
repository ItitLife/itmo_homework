package lesson12.hw1;
/*1. Метод *static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException*
принимает на вход enum и выбрасывает следующие исключения в зависимости от значения status:
    1. если status FILE_NOT_FOUND, выбрасывает FileNotFoundException
    2. если status ACCESS_DENIED, выбрасывает AccessDeniedException
    3. если status JAR_ERROR, выбрасывает JarException.

При вызове метода throwException обработать исключения следующим образом:
*FileNotFoundException* - выводить в консоль сообщение исключения(метод getMessage()) + любое дополнительное сообщение,
*AccessDeniedException* - выводить в консоль сообщение исключения (метод getMessage()) и снова выбрасывать exception,
*JarException* - выводить в консоль стек трейс.

enum Status с необходимыми константами нужно создать.*/

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class RandomExceptions extends Exception {

    public static void throwException(Status status) throws JarException, AccessDeniedException, FileNotFoundException {
        switch (status) {
            case JAR_ERROR:
                throw new JarException();
            case ACCESS_DENIED:
                throw new AccessDeniedException("nope");
            case FILE_NOT_FOUND:
                throw new FileNotFoundException();

        }
    }

    public static RuntimeException getSomeRE() {
        int r = (int) (Math.random() * 9);
        switch (r) {
            case 0:
                return new IllegalArgumentException();
            case 1:
                return new ArithmeticException();
            case 2:
                return new IndexOutOfBoundsException();
            case 3:
                return new NumberFormatException();
            case 4:
                return new ArrayIndexOutOfBoundsException();
            case 5:
                return new ClassCastException();
            case 6:
                return new IllegalMonitorStateException();
            case 7:
                return new NegativeArraySizeException();
            case 8:
                return new SecurityException();
            default:
                return null;
        }
    }
}
