package lesson7.hw1;

import java.util.Scanner;

public class School {
    private String name;
    private Director director;
    private Teacher[] teachers = new Teacher[5];
    private Student[] students = new Student[20];
    Scanner scanner = new Scanner(System.in);

    public School(final String name, Director director) {
        if (name.length() < 3) {
            System.out.println("Название школы должно быть больше 3 символов");
            return;
        }
        this.name = name;
        if (director == null) {
            System.out.println("Необходимо указать директора");
            return;
        }
        this.director = director;
        addTeachers();
        addStudents();
    }

    public void newDay() {
        int i = 0;
        while (Director.day) {
            for (Teacher teacher : teachers) {
                for (int j = 0; j < students.length; j++) {
                    int r = (int) (Math.random() * students.length);
                    if (teacher.subject.equals(students[r].subject)) {
                        teacher.teach(students[r]);
                        break;
                    }
                }
            }
            System.out.println(++i + " day left");
            System.out.println("Введите 0, чтобы прекратить учение\nВведите другое целое число, чтобы продолжить");
            if (scanner.nextInt() == 0) {
                director.finishDay();
            }
        }
    }

    public void addTeachers() {
        for (int i = 0; i < teachers.length; i++) {
            teachers[i] = new Teacher();
        }
    }

    public void addStudents() {
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
        }
    }

    public void studyLevelInfo() {
        for (Student student : students) {
            System.out.println(student.name + "/" + student.age + ": " + student.getStudyLevel());
        }
    }

    public void teachersInfo() {
        for (Teacher teacher : teachers) {
            System.out.print(teacher.name + "/" + teacher.age + ": " + teacher.subject + " | ");
        }
        System.out.println("");
    }

    public void studentsInfo() {
        for (Student student : students) {
            System.out.print(student.name + "/" + student.age + ": " + student.subject + " | ");
        }
        System.out.println("");
    }
}

