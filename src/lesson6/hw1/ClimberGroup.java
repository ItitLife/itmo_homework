package lesson6.hw1;

import java.util.Arrays;

/*Группа для восхождения на гору создаётся со следующими характеристиками: <br>
    идёт набор в группу или нет; <br>
    массив альпинистов; <br>
    гора; <br>
    должна быть возможность добавить альпиниста в группу, если набор ещё идёт <br>*/
public class ClimberGroup {
    private boolean open = true;
    private Climber[] climbers;
    private Mountain mountain;

    public ClimberGroup(Mountain mountain, int groupSize) {
        climbers = new Climber[groupSize];
        setMountain(mountain);
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public Climber[] getClimbers() {
        return climbers;
    }

    public Mountain getMountain() {
        return mountain;
    }

    public void setMountain(Mountain mountain) {
        if (mountain == null)
            throw new IllegalArgumentException("Не указана гора");
        this.mountain = mountain;
    }


    public void addClimbers(Climber... newClimbers) {
        if (!open)
            throw new IllegalArgumentException("Группа закрыта");
        if (newClimbers == null || newClimbers.length > climbers.length)
            throw new IllegalArgumentException("Не указаны альпинисты или их больше чем мест в группе");
        for (int i = 0; i < newClimbers.length; i++) {
            for (int j = 0; j < climbers.length; j++) {
                if (climbers[j] == null) {
                    climbers[j] = newClimbers[i];
                    break;
                } else if (j == climbers.length - 1)
                    System.out.println("В группе не хватило места альпинисту: " + newClimbers[i].getName());
            }
        }
    }

    public void closeGroup() {
        this.open = false;
    }

    @Override
    public String toString() {
        return "ClimberGroup{" +
                "open=" + open +
                ", climbers=" + Arrays.toString(climbers) +
                ", mountain=" + mountain +
                '}';
    }
}
