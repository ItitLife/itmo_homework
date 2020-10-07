package lesson6.hw2;

import java.util.Arrays;

/*Класс Мои Продукты <br>
Свойства: разрешенное количество белков / жиров / углеводов / калорий / список разрешенных продуктов (массив) <br>*/
public class MyProducts {
    private Product[] allowedProducts = new Product[15];
    private double allowedProteins;
    private double allowedFats;
    private double allowedCarbohydrates;
    private int allowedCalories;


    MyProducts(int allowedCalories, double allowedProteins, double allowedFats, double allowedCarbohydrates) {
        setAllowedCalories(allowedCalories);
        setAllowedProteins(allowedProteins);
        setAllowedFats(allowedFats);
        setAllowedCarbohydrates(allowedCarbohydrates);
    }

    public void getMyProductsInfo() {
        StringBuilder sb = new StringBuilder();
        for (Product prod : allowedProducts) {
            if (prod != null)
                sb.append(prod.getProductName()).append(" / ");
        }
        System.out.println(sb);
        //System.out.println(allowedProducts);
    }

    public Product[] getAllowedProducts() {
        return allowedProducts;
    }


    public double getAllowedProteins() {
        return allowedProteins;
    }

    public void setAllowedProteins(double allowedProteins) {
        this.allowedProteins = allowedProteins;
    }

    public double getAllowedFats() {
        return allowedFats;
    }

    public void setAllowedFats(double allowedFats) {
        this.allowedFats = allowedFats;
    }

    public double getAllowedCarbohydrates() {
        return allowedCarbohydrates;
    }

    public void setAllowedCarbohydrates(double allowedCarbohydrates) {
        this.allowedCarbohydrates = allowedCarbohydrates;
    }

    public int getAllowedCalories() {
        return allowedCalories;
    }

    public void setAllowedCalories(int allowedCalories) {
        this.allowedCalories = allowedCalories;
    }

    public void addAllowedProducts(Product... someProducts) {
        if (allowedProducts == null)
            throw new IllegalArgumentException("Не указаны продукты");
        if (allowedProducts.length >= someProducts.length)
            for (int i = 0; i < someProducts.length; i++) {
                for (int j = 0; j < allowedProducts.length; j++) {
                    if (allowedProducts[j] == null) {
                        if (someProducts[i].getCalories() <= allowedCalories) {
                            if (someProducts[i].getProteins() <= allowedProteins) {
                                if (someProducts[i].getFats() <= allowedFats) {
                                    if (someProducts[i].getCarbohydrates() <= allowedCarbohydrates) {
                                        allowedProducts[j] = someProducts[i];
                                        break;
                                    } else {
                                        System.out.println(someProducts[i].getProductName() + " содержит слишком много углеводов");
                                        break;
                                    }
                                } else {
                                    System.out.println(someProducts[i].getProductName() + " содержит слишком много жиров");
                                    break;
                                }
                            } else {
                                System.out.println(someProducts[i].getProductName() + " содержит слишком много протеинов");
                                break;
                            }
                        } else {
                            System.out.println(someProducts[i].getProductName() + " содержит слишком много каллорий");
                            break;
                        }
                    }
                }
            }
    }


    @Override
    public String toString() {
        return "MyProducts{" +
                "allowedProducts=" + Arrays.toString(allowedProducts) +
                ", allowedProteins=" + allowedProteins +
                ", allowedFats=" + allowedFats +
                ", allowedCarbohydrates=" + allowedCarbohydrates +
                ", allowedCalories=" + allowedCalories +
                '}';
    }
}
