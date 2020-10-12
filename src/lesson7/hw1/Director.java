package lesson7.hw1;

final public class Director extends Human {
    static boolean day;
    public Director() {
        super();
        age = this.age = 40 + (int) (Math.random() * 40);
    }

    public void startDay(School school) {
        day = true;
        school.newDay();
    }

    public void finishDay() {
        day = false;
    }
}
