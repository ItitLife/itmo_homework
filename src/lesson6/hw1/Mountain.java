package lesson6.hw1;

/*гора создаётся с названием (не менее 4 символов), страной (не менее 4 символов) и высотой (не менее 100 метров) <br>*/

public class Mountain {
    private String name;
    private String country;
    private int height;

    public Mountain(String name, String country, int height) {
        setName(name);
        setCountry(country);
        setHeight(height);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 4)
            throw new IllegalArgumentException("Название горы должно быть больше 4 символов");
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if (country == null || country.length() < 4)
            throw new IllegalArgumentException("Название страны должно быть больше 4 символов");
        this.country = country;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height < 100)
            throw new IllegalArgumentException("Высота горы должна быть более 100 метров");
        this.height = height;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", height=" + height +
                '}';
    }
}
