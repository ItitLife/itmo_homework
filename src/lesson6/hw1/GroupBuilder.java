package lesson6.hw1;
/*Описать объектную модель Альпинист, Гора, Группа для восхождения на гору. <br>
Альпинист создаётся с именем (не менее 3 символов) и адресом проживания (не менее 5 символов). <br>
Гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров) <br>
Группа для восхождения на гору создаётся со следующими характеристиками: <br>
    идёт набор в группу или нет; <br>
    массив альпинистов; <br>
    гора; <br>
    должна быть возможность добавить альпиниста в группу, если набор ещё идёт <br>
В методе main (отдельного класса) создать: <br>
   3 группы для восхождений на 3 различных горы. <br>
   В первой группе 3 альпиниста (набор закрыт) <br>
   Во второй и третьей группах по 2 альпиниста (набор в эти группы закрыт) <br>
При выполнении задания необходимо обращать внимание на модификаторы доступа и выполнять все необходимые проверки. <br>
*/
public class GroupBuilder {
    public static void main(String[] args) {
        Climber john = new Climber("John", "Johns av.");
        Climber iren = new Climber("Iren", "Irens av.");
        Climber alex = new Climber("Alex", "Alex av.");
        Climber ivan = new Climber("Ivan", "Ivans av.");
        Climber oleg = new Climber("Oleg", "Olegs av.");

        Mountain Mount1 = new Mountain("Mount1","Russia", 150);
        Mountain Mount2 = new Mountain("Mount2","England", 250);
        Mountain Mount3 = new Mountain("Mount3","Germany", 350);

        ClimberGroup group1 = new ClimberGroup(Mount1, 4);
        group1.addClimbers(john,alex,iren);
        ClimberGroup group2 = new ClimberGroup(Mount2, 5);
        group2.addClimbers(alex,iren);
        group2.closeGroup();
        ClimberGroup group3 = new ClimberGroup(Mount3,5);
        group3.addClimbers(john,alex);
        group3.closeGroup();
        System.out.println(group1.toString());
        System.out.println(group2.toString());
        System.out.println(group3.toString());

        group1.addClimbers(ivan,oleg);

        System.out.println(group1.toString());


    }
}
