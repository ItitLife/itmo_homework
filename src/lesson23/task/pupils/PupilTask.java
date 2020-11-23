package lesson23.task.pupils;

import lesson22.hw3_5.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PupilTask {
    public static void main(String[] args) {
        // обращение к enum Gender через имя класса - Pupil.Gender
        List<Pupil> pupils = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            pupils.add(Pupil.getNewPupil());
        }

        // Используя Stream API:

        // 1. Разделить учеников на две группы: мальчиков и девочек. Результат: Map<Pupil.Gender, ArrayList<Pupil>>
        Map<Pupil.Gender, ArrayList<Pupil>> genders = pupils.stream().
                collect(Collectors.groupingBy(Pupil::getGender, Collectors.toCollection(ArrayList::new)));
        System.out.println(genders);

        // 2. Найти средний возраст учеников
        double ageAv = pupils.stream().mapToDouble(Pupil::getAge).average().getAsDouble();
        System.out.println(ageAv);

        // 3. Найти самого младшего ученика
        Pupil min = pupils.stream().min((pupil1, pupil2) -> pupil1.getBirth().compareTo(pupil2.getBirth())).get();

        // 4. Найти самого старшего ученика
        Pupil max = pupils.stream().max((pupil1, pupil2) -> pupil1.getBirth().compareTo(pupil2.getBirth())).get();

        // 5. Собрать учеников в группы по году рождения
        Map<Integer, List<Pupil>> byYear = pupils.stream()
                .collect(Collectors.groupingBy(pupil -> pupil.getBirth().getYear(), Collectors.toCollection(ArrayList::new)));
        System.out.println(byYear);

        // 6. Убрать учеников с одинаковыми именами, имена и дату рождения оставшихся вывести в консоль
        pupils.stream().collect(Collectors.toMap(Pupil::getName, pupil -> pupil, (p1, p2) -> p1))
                .forEach((k, v) -> System.out.println(v.getName() + ": " + v.getBirth()));
        // 7. Отсортировать по полу, потом по дате рождения, потом по имени (в обратном порядке), собрать в список (List)
        List<Pupil> sortedPupils = pupils.stream()
                .sorted(Comparator.<Pupil>comparingInt(pupil -> pupil.getGender().ordinal()).
                        thenComparing(Pupil::getBirth).thenComparing(Pupil::getName).reversed())
                .collect(Collectors.toList());
                /*.sorted((p1, p2) -> p1.getGender().compareTo(p2.getGender()))
                .sorted((p1, p2) -> p1.getBirth().compareTo(p2.getBirth()))
                .sorted((p1, p2) -> p2.getName().compareTo(p1.getName())).collect(Collectors.toList());*/


        // 8. Вывести в консоль всех учеников в возрасте от N до M лет
        pupilsByAgePrint(pupils, 7, 10);
        // 9. Собрать в список всех учеников с именем=someName
        System.out.println(pupilsByNameCollect(pupils, "savva"));
        // 10. Собрать Map<Pupil.Gender, Integer>, где Pupil.Gender - пол, Integer - суммарный возраст учеников данного пола
        Map<Pupil.Gender, Integer> someMap = pupils.stream().collect(Collectors.groupingBy(Pupil::getGender, Collectors.summingInt(Pupil::getAge)));
        System.out.println(someMap);
    }

    public static void pupilsByAgePrint(List<Pupil> pupils, int n, int m) {
        pupils.stream().filter(pupil -> (pupil.getAge() > n && pupil.getAge() < m)).forEach(System.out::println);
    }

    public static List<Pupil> pupilsByNameCollect(List<Pupil> pupils, String name) {
        return pupils.stream().filter(pupil -> (pupil.getName().equals(name))).collect(Collectors.toList());
    }
}