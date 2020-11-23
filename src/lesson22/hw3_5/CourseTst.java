package lesson22.hw3_5;

/*3. Написать реализацию метода public List<Course> filtered(Predicate<Course> filter) класса University.
4. Использовать реализованный в п.3 метод для получения списков курсов:

       продолжительностью менее 3х месяцев;
       стоимостью менее 20000;
       курсов с названием JJD;
       продолжительностью менее 3х месяцев и стоимостью менее 20000;
       продолжительностью менее 3х месяцев и стоимостью менее 20000 или курсов с названием JJD;

5. Используя метод foreach увеличить стоимость всех курсов на 10000. */

import java.util.function.Predicate;

public class CourseTst {
    public static void main(String[] args) {
        University university = new University();
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        university.addCourse(Course.getInstance());
        System.out.println("1: " + university.getCourses());

        System.out.println("2: " + university.filtered(course -> course.getDuration() < 3));

        System.out.println("3: " + university.filtered(course -> course.getPrice() < 20000));

        System.out.println("4: " + university.filtered(course -> course.getName().toLowerCase().equals("jjd")));

        Predicate<Course> shortDuration = course -> course.getDuration() < 3;
        Predicate<Course> lowPrice = course -> course.getPrice() < 20000;
        Predicate<Course> jjdCourse = course -> course.getName().toLowerCase().equals("jjd");

        System.out.println("5: " + university.filtered(shortDuration.and(lowPrice)));

        System.out.println("6: " + university.filtered((shortDuration.and(lowPrice)).or(jjdCourse)));

        university.getCourses().forEach(course -> course.setPrice(course.getPrice() + 10000));

    }
}
