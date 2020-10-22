package lesson11.hw2;

/*Задача: написать enum, который перечисляет планеты Солнечной системы и возвращает массу планеты, ее радиус и радиус орбиты.*/

public enum Planets {
    MERCURY(3.33022,2439.7,46001009.0),
    VENUS(48.675,6051.8,107476259.0),
    EARTH(59.726,6371.0,147098290.0),
    MARS(6.4171,3389.5,206655000.0),
    JUPITER(18986,69911,740573600.0),
    SATURN(5684.6,58232.0,1353572956.0),
    URANUS(868.13,25362.0,2748938461.0),
    NEPTUNE(1024.3,24622.0,4452940833.0);
    private double mass; // 10^23
    private double radius; // km
    private double perihelion; //km

    Planets(double mass, double radius, double perihelion) {
        this.mass = mass;
        this.radius = radius;
        this.perihelion = perihelion;
    }

    public String getParameters (){
        return "Mass: " + mass + ", Radius: " + radius + " , Perihelion: " + perihelion;
    }
}
