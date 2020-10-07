package lesson6.hw3;

// имя public класса должно соответсвовать имени файла (не обязательно для не public)
// в фале может быть только один public класс
// область видимости public класса - вся программа, у обычного (просто class) - пакет
// название
// количество картинок
// автор
public class ColouringBook {
    // свойства / поля / атрибуты
    private String title; // название, значение по умолчанию null
    private int imageCount;  // количество картинок, значение по умолчанию 0
    private Author author; // автор
    // значение свойств по умолчанию:
    // boolean: false
    // целочисленные: 0
    // с плавающей точкой: 0.0
    // char: /u0000
    // ссылочные типы: null

    // модификаторы доступа:
    // private - доступны только в рамках текущего класса (от { до } текущего класса)
    // public - доступны из любого участка программы
    // package-private/default (если не установлен) - доступны в рамках пакета
    // protected - доступны в рамках пакета + в рамках дочерних классов

    // setter - метод, который позволит выполнить проверку входящих данных
    // и установить значение свойства объекта (если проверки пройдены)
    // желательно 1 действие - 1 метод, в имени глагол означающий действие
    // public - модификатор доступа
    // void - метод выполняет действие и не возвращает результат
    // setTitle - имя метода должно отражать то , что происходит в методе
    // (String title) - в скобках указываются принимаемые аргументы, принимает на вход объект типа String
    public void setTitle(String title) {
        // title должен быть не null и длина больше 3
        if (title == null || title.trim().length() < 3)
            throw new IllegalArgumentException("title меньше 3");

        // присваиваем значение свойства title равное (String title)
        // this - ссылка на текущий объект
        // (this можно не использовать только если имя свойства и имя передаваемого аргумента РАЗНЫЕ)
        this.title = title;
    }

    // getter - метод, который возвращает значение свойства
    // public - моификатор доступа
    // String - тип возвращаемого значения
    // getTitle - имя метода
    // () - без аргументов
    public String getTitle() {
        // return прерывает работу метода
        // возвращает результат работы метода
        return title;
    }
    // либо Alt + Insert / либо правой кнопкой и generate


    public int getImageCount() {
        return imageCount;
    }

    public void setImageCount(int imageCount) {
        if (imageCount < 5)
            throw new IllegalArgumentException("imageCount должно быть больше 5");
        this.imageCount = imageCount;
    }

    public Author getAuthor() {
        if (author == null)
            throw new IllegalArgumentException("author не должен быть null");
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "ColouringBook{" +
                "title='" + title + '\'' +
                ", imageCount=" + imageCount +
                ", author=" + author +
                '}';
    }
    // класс {
    // свойства
    // конструкторы
    // геттеры + сеттеры
    // методы класса
    // переопределённые методы
    // }
}
