package additionalTasks.inheritanceInterfaces;

import lesson7.hw1.NamesAndSubjects;

abstract public class Animal {
    private String name;
    protected int weight;
    protected int speed;

    public Animal() {
        this.name = NamesAndSubjects.getName();
    }
}
