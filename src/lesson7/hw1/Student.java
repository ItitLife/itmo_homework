package lesson7.hw1;

public class Student extends Plebeians implements StudyAble{
    int studyLevel;

    public Student(String name, int age, String subject, int studyLevel) {
        super(name, age, subject);
        if (studyLevel < 0) {
            System.out.println("Уровень знаний скорее всего не может быть отрицательным");
            return;
        }
        this.studyLevel = studyLevel;
    }

    @Override
    public void study() {
        studyLevel++;
    }
}
