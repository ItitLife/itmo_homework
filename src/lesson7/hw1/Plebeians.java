package lesson7.hw1;

abstract class Plebeians extends Human {
    String subject;

    public Plebeians() {
        super();
        this.subject = NamesAndSubjects.getSubject();
    }

}
