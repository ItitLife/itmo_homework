package lesson12.hw1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class ExceptionGenerator {
    public static void main(String[] args) {
        Status status = Status.getRandomStatus();
        try {
            RandomExceptions.throwException(status);
        } catch (JarException e) {
            e.printStackTrace();
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
            try {
                throw new AccessDeniedException("nope").initCause(e);
            } catch (AccessDeniedException ex) {
                System.out.println(e.getMessage());
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage() + "!FileNotFoundException!");
        }
    }
}
