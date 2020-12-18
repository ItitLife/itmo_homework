package lesson25;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static String onlyWords(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer("");
        Files.lines(Paths.get("resources/lesson23_text.txt"))
                .parallel()
                .peek(string -> string.toLowerCase())
                .peek(string -> string.replace("[^A-Za-z]", " ").trim()).forEach(el -> sb.append(el).append(" "));
        return sb.toString();
    }

    /*public static Map<String, Long> getTopWords(String text) {
        String[] strArr = text.trim().split(" ");
        List<String>[] listsArr = new List[Runtime.getRuntime().availableProcessors()];


        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {

        }

    }*/
}

class GetThread implements Runnable{


    @Override
    public void run() {

    }
}
