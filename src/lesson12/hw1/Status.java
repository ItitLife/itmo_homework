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

enum Status с необходимыми константами нужно создать.
*/
public enum Status {
    FILE_NOT_FOUND, ACCESS_DENIED, JAR_ERROR;

    public Status getRandomStatus() {
        if (System.currentTimeMillis() % 3 == 0)
            return Status.FILE_NOT_FOUND;
        if (System.currentTimeMillis() % 3 == 1)
            return Status.ACCESS_DENIED;
        if (System.currentTimeMillis() % 3 == 2)
            return Status.JAR_ERROR;
        return null;
    }
}
