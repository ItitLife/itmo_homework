package lesson7.hw1;

public class School {
    String name;
    Director director = new Director("Some", 22);
    Teacher[] teachers = new Teacher[5];
    Student[] students = new Student[20];

    public void newDay() {
        if (director.startDay()) {
            for (int i = 0; i < teachers.length; i++) {
                for (int j = 0; j < students.length; j++) {
                    if (students[j].subject == teachers[i].subject) {
                        teachers[i].teach(students[j]);
                        break;
                    }
                }
            }
        }
    }
}

