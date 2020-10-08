package lesson7.hw1;

abstract public class Human {
    protected String name;
    protected int age;

    public Human(String name, int age) {
        if (name.length() < 3) {
            System.out.println("Имя должно быть больше 3 символов");
            return;
        }
        this.name = name;
        if (age < 7) {
            System.out.println("Возраст должен быть больше 7");
            return;
        }
        this.age = age;
    }
}
