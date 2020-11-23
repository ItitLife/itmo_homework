package lesson22.hw1;

/*
1. Отработать написание лямбда (написать по 2 реализации) для: Predicate, Function, UnaryOperator, BinaryOperator, Consumer
2. Переписать компараторы из lesson15/hw с использованием синтаксиса лямбд
*/

import lesson15.hw.compare.Car;
import lesson7.hw1.*;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class App {
    public static void main(String[] args) {
        Predicate<Human> humanValidator = human -> (human.getAge() > 0 && human.getName() != null && human.getName().length() > 0);
        Teacher teacher = new Teacher();
        System.out.println(humanValidator.and(human -> human.getAge() > 20).test(teacher));


        Function<Teacher, Student> teacherToStudent = someTeacher -> new Student(someTeacher.getName(),
                7 + (int) (Math.random() * 11), someTeacher.getSubject(), 100);

        Student student = teacherToStudent.apply(teacher);
        System.out.println(student.getAge());


        UnaryOperator<Car> redToBlue = car -> {
            if (car.getColor().toLowerCase() == "red") car.setColor("blue");
            return car;
        };



    }
}
