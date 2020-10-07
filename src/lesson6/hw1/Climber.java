package lesson6.hw1;

public class Climber {
    private String name;
    private String address;

    public Climber(String name, String address) {
        setName(name);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.length() < 3)
            throw new IllegalArgumentException("Имя должно быть длинее 3 символов");
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (address == null || address.length() < 5)
            throw new IllegalArgumentException("Адрес должен быть длинее 5 символов");
        this.address = address;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
