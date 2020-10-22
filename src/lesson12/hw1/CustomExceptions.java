package lesson12.hw1;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class CustomExceptions extends Exception {

    public static void throwException(Status status) {
        switch (status) {
            case JAR_ERROR:
                try {
                    throw new JarException();
                } catch (JarException e) {
                    e.printStackTrace();
                }
            case ACCESS_DENIED:
                try {
                    throw new AccessDeniedException("");
                } catch (AccessDeniedException e) {
                    e.printStackTrace();
                }
            case FILE_NOT_FOUND:
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
        }
    }

}
