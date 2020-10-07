package lesson6.hw3;

import java.util.Arrays;

public class ColouringShelf {
    private ColouringBook[] colouring;
    private String color = "красный";

    // конструктор
    public ColouringShelf(int count) {
        if (count < 10)
            throw new IllegalArgumentException("count не должен быть меньше 10");
        colouring = new ColouringBook[count];
    }

    public ColouringShelf(int count, String color) {
        this(count); // вызов конструктора
        this.setColor(color);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color == null || color.trim().length() < 3)
            throw new IllegalArgumentException("color должен быть больше 3");
        this.color = color;
    }

    // return в void методах используется исключительнео для прерывания его работы (ничего не возвращает)
    public void addColouring(ColouringBook newBook) {
        for (int i = 0; i < colouring.length; i++) {
            if (colouring[i] == null) {
                colouring[i] = newBook;
                return;
            }
        }
    }

    public void addColouring(ColouringBook... books) {
        if (books.length <= colouring.length) {
            for (int i = 0; i < books.length; i++) {
                for (int j = 0; j < colouring.length; j++) {
                    if (colouring[j] == null) {
                        colouring[j] = books[i];
                        break;
                    }
                }
            }
        } else
            System.out.println("Полка слишком мала");
    }

    public String getBooksInfo() {
        StringBuilder sb = new StringBuilder();
        for (ColouringBook book : colouring) {
            if (book != null)
                sb.append(book.getTitle()).append(" ")
                        .append(book.getImageCount()).append(" \\ ");
        }
        return sb.toString();
    }


    @Override
    public String toString() {
        return "ColouringShelf{" +
                "colouring=" + Arrays.toString(colouring) +
                ", color='" + color + '\'' +
                '}';
    }
}
