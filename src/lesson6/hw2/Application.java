package lesson6.hw2;

/*Класс Пищевая Ценность <br>
Свойства: имя продукта / белки / жиры / углеводы / калории <br>
Минимум 4 конструктора <br>
Реализовать необходимые проверки входящих данных <br>
Создать не менее 4 экземпляров данного класса (объектов) <br>
Класс Мои Продукты <br>
Свойства: разрешенное количество белков / жиров / углеводов / калорий / список разрешенных продуктов (массив) <br>
Реализовать метод, который принимает на вход название продукта и добавляет его в список разрешенных, <br>
если характеристики продукта полностью соответствуют заявленным разрешениям, <br>
в противном случае сообщить, по какой причине продукт не может быть добавлен в список <br>
Реализовать метод, который показывает список разрешенных продуктов <br>
При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки. <br>
*/
public class Application {
    public static void main(String[] args) {
        Product product1 = new Product("Product1", 1150,15.5,20.5,60);
        Product product2 = new Product("Product2", 0,1,2,3);
        Product product3 = new Product("Product3", 15,10,17,33);
        Product product4 = new Product("Product4", 200,24,25,48);

        MyProducts myProducts1 = new MyProducts(200,50,50,50);
        MyProducts myProducts2 = new MyProducts(15,15,2,1);
        MyProducts myProducts3 = new MyProducts(2000,550,508,350);
        MyProducts myProducts4 = new MyProducts(0,0,0,0);

        myProducts1.addAllowedProducts(product1,product2,product3);
        myProducts1.getMyProductsInfo();
       // System.out.println(Arrays.toString(myProducts1.getAllowedProducts()));
    }
}
