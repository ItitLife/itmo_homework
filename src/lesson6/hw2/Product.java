package lesson6.hw2;

/*Класс Пищевая Ценность <br>
Свойства: имя продукта / белки / жиры / углеводы / калории <br>
Минимум 4 конструктора <br>
Реализовать необходимые проверки входящих данных <br>
Создать не менее 4 экземпляров данного класса (объектов) <br> */
public class Product {
    private String productName;
    private double proteins;
    private double fats;
    private double carbohydrates;
    private int calories;

    public Product(String productName) {
        setProductName(productName);
    }

    public Product(String productName, int calories, double proteins, double fats, double carbohydrates) {
        setProductName(productName);
        setCalories(calories);
        setProteins(proteins);
        setFats(fats);
        setCarbohydrates(carbohydrates);
    }

    public Product(String productName, int calories) {
        setProductName(productName);
        setCalories(calories);
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (productName == null || productName.length() < 3)
            throw new IllegalArgumentException("Назавание продукта должно содержать больше 3 символов");
        this.productName = productName;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        if (proteins < 0)
            throw new IllegalArgumentException("Содержание белков не может быть отрицательным");
        this.proteins = proteins;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        if (fats < 0)
            throw new IllegalArgumentException("Содержание жиров не может быть отрицательным");
        this.fats = fats;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        if (carbohydrates < 0)
            throw new IllegalArgumentException("Содержание углеводов не может быть отрицательным");
        this.carbohydrates = carbohydrates;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        if (calories < 0)
            throw new IllegalArgumentException("Калораж не может быть отрицательным");
        this.calories = calories;
    }

    @Override
    public String toString() {
        return productName;

    }
}
