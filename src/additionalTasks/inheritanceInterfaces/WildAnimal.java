package additionalTasks.inheritanceInterfaces;

/*Дикие животные:
Волк, Медведь, Лисица.
обладают следующими характеристиками:
имя, вес, скорость, сила
Дикое животное может съесть (либо ранить) домашнее животное, если оно не убежит.
Если домашнее животное было съедено, то оно не остается на ферме (из массива удалять не обязательно, можно использовать какой нибудь флаг, onFarm:true/false)!
Если фермер прогнал дикое животное с фермы 3 раза, то в 4й раз оно не может прийти на ферму.*/
public class WildAnimal extends Animal {
    int force;
    byte fail;

    public WildAnimal(int weight, int speed, int force) {
        super();
        this.weight = weight;
        this.speed = speed;
        this.force = force;
        this.fail = 0;
    }

    public static WildAnimal getWildAnimal() {
        String[] types = new String[]{"fox", "bear", "wolf"};
        WildAnimal wildAnimal = null;
        switch (types[(int) (Math.random() * types.length)]) {
            case "fox":
                wildAnimal = new WildAnimal(25, 25, 3);
                break;
            case "bear":
                wildAnimal = new WildAnimal(500, 15, 20);
                break;
            case "wolf":
                wildAnimal = new WildAnimal(50, 20, 8);
                break;
        }
        return wildAnimal;
    }

    public static WildAnimal[] getWildAnimals() {
        WildAnimal[] wildAnimals = new WildAnimal[3];
        for (WildAnimal wildAnimal : wildAnimals) {
            wildAnimal = getWildAnimal();
        }
        return wildAnimals;
    }
}