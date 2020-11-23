package lesson7.hw1;

public abstract class Plebeians extends Human {
    String subject;

    public Plebeians() {
        super();
        this.subject = NamesAndSubjects.getSubject();
    }

    public Plebeians(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }
}
