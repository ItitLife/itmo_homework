package lesson6.hw3;

public class Author {
    private String firstName; // name
    private String secondName; // surname


    // конструктор (может не быть, по умолчанию конструктор без аргументов есть в каждом классе)
    // конструктор без параметров нужно прописывать всегда, когда необходимы конструкторы с параметрами и без них
    public Author() {
    }

    public Author(String firstName) {
        setFirstName(firstName);
        //this.firstName = firstName;
    }

    public Author(String firstName, String secondName) {
        setFirstName(firstName);
        setSecondName(secondName);
        //this.firstName = firstName;
        //this.secondName = secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().length() < 3)
            throw new IllegalArgumentException("Имя должно быть больше 3");
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        if (secondName == null || secondName.trim().length() < 3)
            throw new IllegalArgumentException("Фамилия должна быть больше 3");
        this.secondName = secondName;
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                '}';
    }
}
