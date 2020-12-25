package exams.thirdFox;

import exams.thirdFox.commands.Menu;
import exams.thirdFox.stategy.SituationPerformer;

public class App {
    public static void main(String[] args) {
        Menu mainMenu = Menu.getMainMenu();
        mainMenu.printMenu();
        mainMenu.startMenu();

    }
}
