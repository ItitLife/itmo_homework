package lesson26;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

enum Food {
    PASTA(100), PIZZA(200), SOME_OTHER_FOOD(5);

    private int cost;

    Food(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Food getSomeFood() {
        return Arrays.asList(Food.values()).get((int) (Math.random() * Food.values().length));
    }
}

public class Order {
    LocalDateTime localDateTime;
    List<Food> food;
    int tableNumber;

    public Order(List<Food> food, int tableNumber) {
        this.localDateTime = LocalDateTime.now();
        this.food = food;
        this.tableNumber = tableNumber;
    }

}
