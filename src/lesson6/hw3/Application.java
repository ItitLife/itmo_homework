package lesson6.hw3;

public class Application {
    public static void main(String[] args) {
        // создание объекта
        // тип_данных имя_объекта = new конструктор();
        ColouringBook dogs = new ColouringBook();
        ColouringBook flowers = new ColouringBook();
        // ображение к свойству // название
        // dogs.title = "Собаки"; //
        // доступ к свойству напрямую даёт возможность указать там, что угодно или оставить null, что черевато ошибками
        // например dogs.title = ""; dogs.title = null;
        // поэтому лучше ограничить доступ к свойству, указач модификатор private перед свойством в классе ColouringBook
        dogs.setTitle("Собаки");
        flowers.setTitle("Цветы");

        String dogsTitle = dogs.getTitle();
        System.out.println(dogs.getTitle());

        Author ivan = new Author("Иван", "петров");

        //ivan.setSecondName("Иванов");
        System.out.println(ivan.getFullName());
        dogs.setAuthor(ivan);
        // dogs.getAuthor() -> объект Author
        System.out.println(dogs.getAuthor().getFullName());
        System.out.println(dogs);
        System.out.println("          ".length());
        ColouringShelf shelf = new ColouringShelf(10,"white");
        System.out.println(shelf);

        shelf.addColouring(dogs);
        shelf.addColouring(flowers);
        System.out.println(shelf.getBooksInfo());

        shelf.addColouring(dogs, flowers);
        System.out.println(shelf.getBooksInfo());

    }
}
