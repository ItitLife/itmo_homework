package lesson7.hw1;

public class Teacher extends Plebeians implements TeachAble{
    public Teacher() {
        super();
        this.age = 22 + (int) (Math.random() * 22);
    }

    /*@Override
    public void teach(Student student) {
        if (this.subject == student.subject)
        student.study();
    }*/
}
