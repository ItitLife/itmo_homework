package lesson7.hw1;

public class Student extends Plebeians implements StudyAble{
    int studyLevel;

    public Student() {
        super();
        if (studyLevel < 0) {
            System.out.println("Уровень знаний скорее всего не может быть отрицательным");
            return;
        }
        this.studyLevel = studyLevel;
    }

    public int getStudyLevel() {
        return studyLevel;
    }

    @Override
    public void study() {
        studyLevel++;
    }
}
