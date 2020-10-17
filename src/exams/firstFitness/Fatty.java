package exams.firstFitness;

import lesson7.hw1.NamesAndSubjects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Fatty {
    private String name;
    private String sername;
    private LocalDate birthday;
    private String wish;

    public Fatty(String name, String sername, LocalDate birthday) {
        setName(name);
        setSername(sername);
        setBirthday(birthday);
    }

    private void setName(String name) {
        if (Objects.isNull(name) || name.length() < 3)
            throw new IllegalArgumentException("Имя должно быть длиннее 3 символов");
        this.name = name;
    }

    private void setSername(String sername) {
        if (Objects.isNull(sername) || sername.length() < 3)
            throw new IllegalArgumentException("Фамилия должна быть длиннее 3 символов");
        this.sername = sername;
    }

    private void setBirthday(LocalDate birthday) {
        if (birthday.isAfter(LocalDate.now().minusYears(10)))
            throw new IllegalArgumentException("Клиент должен быть старше 10 лет");
        this.birthday = birthday;
    }


    public String getWish() {
        return wish;
    }

    private static String addWish() {
        String[] wish = new String[]{"pool", "gym", "groupClass"};
        return wish[(int) (Math.random() * wish.length)];
    }

    public static Fatty addFatty() {
        Fatty fatty = new Fatty(NamesAndSernames.getName(), NamesAndSernames.getSername(),
                LocalDate.of(1960, 01, 01).plusYears((int) (Math.random() * 30)).plusDays((int) (Math.random() * 366)));
        fatty.wish = addWish();
        return fatty;
    }

    @Override
    public String toString() {
        return "[" + sername + " " + name + "]";
    }
}
