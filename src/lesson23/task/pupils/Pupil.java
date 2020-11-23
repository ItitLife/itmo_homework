package lesson23.task.pupils;

import lesson7.hw1.NamesAndSubjects;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Pupil {
    enum Gender {
        MALE, FEMALE
    }
    private int number; // уникальное значение для каждого ученика
    private String name;
    private Gender gender;
    private LocalDate birth;

    // TODO: добавить все необходимые методы

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public int getAge(){
        return (int) (ChronoUnit.YEARS.between(birth, LocalDate.now()));
    }

    public static Pupil getNewPupil() {
        Pupil pupil = new Pupil();
        pupil.number = (int) System.currentTimeMillis();
        pupil.name = NamesAndSubjects.getName();
        pupil.gender = System.currentTimeMillis() % 2 == 0 ? Gender.FEMALE : Gender.MALE;
        pupil.birth = LocalDate.now().minusYears(7 + (int) (Math.random() * 10)).minusDays((int) (Math.random() * 366));
        return pupil;
    }

    @Override
    public String toString() {
        return "Pupil{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                '}';
    }
}