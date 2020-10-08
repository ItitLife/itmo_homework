package lesson7.hw1;

abstract class Plebeians extends Human {
    String subject;

    public Plebeians(String name, int age, String subject) {
        super(name, age);
        if (subject.length() < 3) {
            System.out.println("Название предмета должно быть больше 3 символов");
            return;
        }
        this.subject = subject;
    }
}
