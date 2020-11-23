package lesson16.hw;

import java.util.*;
import java.util.List;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");
        String city = "Тверь";


        // TODO:: дан список слов (words).
        //  Написать метод, который будет возвращать количество
        //  одинаковых слов с списке
        //  в виде Map<String, Integer>,
        //  где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");


        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели,
        //  возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        System.out.println(GroupByLettersAmount(text));
        TopWords(text);
        LettersPercentage(text);

    }

    public static HashMap<String, Customer> getByAge(
            HashMap<String, Customer> map,
            int from, int to
    ) {
        HashMap<String, Customer> newMap = new HashMap<>();
        for (Map.Entry<String, Customer> entry : map.entrySet()) {
            if (entry.getValue().getAge() >= from &&
                    entry.getValue().getAge() < to) {
                newMap.put(entry.getKey(), entry.getValue());
            }
        }
        return newMap;
    }

    public static List<String> LoginsByCity(Map<String, String> map, String city) {
        // TODO:: написать статический метод, который приннимает на вход мапу (firstTaskMap) и город (city)
        //  и формирует список (List) логинов, которые соответствуют переданному городу
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue().equals(city)) list.add(entry.getKey());
        }
        return list;
    }

    public static Map<String, Integer> WordsCounter(List<String> list) {
        // TODO:: дан список слов (words).
        //  Написать метод, который будет возвращать количество
        //  одинаковых слов с списке
        //  в виде Map<String, Integer>,
        //  где String - слово и Integer - количество повторений
        /*HashSet<String> uniqueWords = new HashSet<>(list);*/
        HashMap<String, Integer> map = new HashMap<>();
        /*for (String uniqueWord : uniqueWords) {
            int count = 0;
            for (String s : list) {
                if (uniqueWord.equals(s)) count++;
            }
            map.put(uniqueWord, count);
        }
        return map;*/
        for (String s : list) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map;
    }


    public static Map<String, Customer> CustomerByAge(Map<String, Customer> map, int from, int to) {
        // TODO:: дана мапа (customerMap).
        //  Написать метод, который принимает на вход агрументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели,
        //  возраст которых находится в диапазоне [from, to)
        HashMap<String, Customer> newMap = new HashMap<>();
        Iterator<Map.Entry<String, Customer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getAge() >= from && iterator.next().getValue().getAge() <= to)
                newMap.put(iterator.next().getKey(), iterator.next().getValue());
        }
        return newMap;
    }

    public static int wordCounterInText(String text, String word) {
        // TODO:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //ArrayList<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
        String[] words = text.split(" ");
        int count = 0;
        for (String s : words) {
            if (s.equals(word)) count++;
        }
        return count;
    }

    public static Map<Integer, Set<String>> GroupByLettersAmount(String text) {
        // TODO:
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        /*TreeMap<Integer, List<String>> groupsByLettersAmount = new TreeMap<>();
        LinkedList<String> words = new LinkedList<>(Arrays.asList(text.toLowerCase().split(" ")));
        Collections.sort(words, new WordsByLengthComparator());
        words.getLast().length();
        LinkedHashSet<String> uniqueWords = new LinkedHashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        for (int i = words.getFirst().length(); i <= words.getLast().length(); i++) {
            groupsByLettersAmount.put(i, new ArrayList<String>());
        }
        for (String word : uniqueWords) {
            for (Map.Entry<Integer, List<String>> entry : groupsByLettersAmount.entrySet()) {
                if (word.length() == entry.getKey()) entry.getValue().add(word);
            }
        }
        return groupsByLettersAmount;*/
        Map<Integer, Set<String>> map = new TreeMap<>();
        String[] words = text.trim().toLowerCase().split(" ");
        for (String word : words) {
            Set<String> strings = map.getOrDefault(word.length(), new HashSet<>());
            strings.add(word);
            map.put(word.length(), strings);
        }
        return map;


    }

    public static void TopWords(String text) {
        // TODO:
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        /*HashMap<String, Integer> wordsCount = new HashMap<>();
        LinkedList<String> topTen = new LinkedList<>();
        ArrayList<String> words = new ArrayList<>(Arrays.asList(text.toLowerCase().split(" ")));
        HashSet<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word);
        }
        for (String uniqueWord : uniqueWords) {
            int count = 0;
            for (String word : words) {
                if (word.toLowerCase().equals(uniqueWord)) count++;
            }
            wordsCount.put(uniqueWord, count);
        }
        int max = 0;
        for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
            if (entry.getValue() > max) max = entry.getValue();
        }
        for (int i = max, j = 10; i > 0; i--) {
            for (Map.Entry<String, Integer> entry : wordsCount.entrySet()) {
                if (entry.getValue().equals(i) && j > 0) {
                    topTen.add(entry.getKey() + ": " + entry.getValue());
                    j--;
                }
            }
        }
        System.out.println(topTen);*/
        String[] words = text.trim().toLowerCase().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String word : words) {
            hashMap.put(word, hashMap.getOrDefault(word, 0) + 1);
        }
        TreeSet<Map.Entry<String, Integer>> entries = new TreeSet<>(new WordsByCountComparator());
        entries.addAll(hashMap.entrySet());

    }

    public static void LettersPercentage(String text) {
        // TODO:
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы
        String[] lettersFromText = text.toLowerCase().split("");
        HashMap<Character, Integer> lettersCount = new HashMap<>();
        LinkedList<Character> chars = new LinkedList<>();
        for (char i = 'a'; i <= 'z'; i++) {
            chars.add(i);
        }
        for (Character aChar : chars) {
            int count = 0;
            for (String s : lettersFromText) {
                if (s.equals(aChar.toString())) count++;
            }
            lettersCount.put(aChar, count);
        }
        int sum = 0;
        for (Map.Entry<Character, Integer> entry : lettersCount.entrySet()) {
            sum += entry.getValue();
        }
        for (Map.Entry<Character, Integer> entry : lettersCount.entrySet()) {
            double percentage = entry.getValue() * 100.0 / sum;
            System.out.println(entry.getKey() + ": " + percentage);
        }
    }
}

class WordsByLengthComparator implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        return Integer.compare(s1.length(), s2.length());
    }
}

class WordsByCountComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        if (o1.getValue().equals(o2.getValue())) return -1;
        return Integer.compare(o1.getValue(), o2.getValue());
    }
}
