package lesson23.task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TopTenWords {
    public static void main(String[] args) throws IOException {
        // создать Map<String, Long> map
        // String - слово
        // Long - частота встречаемости
        // в мапу должны войти только первые 10 частоте встречаемости слов

        // содержимое файла может быть любым
        // Map<String, Long> map = Files.lines(Paths.get("sources/task23.txt")) // читаем из файла в stream
        // методы вызывать по цепочке,
        // цепочку не разрывать (пока не получите результирующую мапу)

        // System.out.println(map);
        Map<String, Long> map = Files.lines(Paths.get("resources/lesson23_text.txt"))
                .parallel()
                .peek(string -> string.toLowerCase())
                .flatMap(string -> Arrays.stream(string.split("[a-zA-Z]")))
                .filter(string -> !string.equals(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .parallelStream()
                .sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()))
                .limit(10)
                .collect(Collectors.toMap(w -> w.getKey(), n -> n.getValue()));
        System.out.println(map);

    }
}




