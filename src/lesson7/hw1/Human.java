package lesson7.hw1;

abstract public class Human {
    protected String name;
    protected int age;

    public Human() {
        this.name = NamesAndSubjects.getName();
        this.age = 7 + (int) (Math.random() * 11);
    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

}
