package additionalTasks.inheritanceInterfaces;

/*Домашние животные: Корова, Кот, Курица, Кролик
обладают следующими характеристиками:
имя, вес, скорость, здоровье, количество ресурсов (у каждого свое и 0, если животное на дает ресурс)
Есть домашние животные, которые дают ресурсы:  Корова, Курица
Есть домашние животные, которые пригодны в пищу: Кролик, Корова, Курица
Домашнее животное может убежать от дикого животного, если его скорость больше.
Домашнее животное может восполнять здоровье (+1, но не больше изначального).
Животные восполняют здоровье во время кормления.*/
public class Pet extends Animal {
    int health;
    int resources;
    int maxHealth;


    public Pet(int weight, int speed, int health, int resources) {
        super();
        this.weight = weight;
        this.speed = speed;
        this.health = health;
        this.resources = resources;
        this.maxHealth = health;
    }

    public void plusHealth() {
        if (health <= maxHealth)
            health++;
    }

    public boolean isDead() {
        return health < 0;
    }


    public static Pet getPet() {
        String[] types = new String[]{"chicken", "rabbit", "cow", "cat"};
        Pet pet = null;
        switch (types[(int) (Math.random() * types.length)]) {
            case "chicken":
                pet = new Pet(4, 16, 3, 1);
                break;
            case "rabbit":
                pet = new Pet(8, 13, 8, 0);
                break;
            case "cow":
                pet = new Pet(400, 8, 30, 3);
                break;
            case "cat":
                pet = new Pet(5, 12, 5, 0);
                break;
        }
        return pet;
    }

}
