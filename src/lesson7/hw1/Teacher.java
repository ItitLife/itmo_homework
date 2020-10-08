package lesson7.hw1;

public class Teacher extends Plebeians implements TeachAble{
    public Teacher(String name, int age, String subject) {
        super(name, age, subject);

    }

    @Override
    public void teach(Student student) {
        if (this.subject == student.subject)
        student.study();
    }
}
