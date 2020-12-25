package exams.thirdFox.commands;

import exams.thirdFox.stategy.SituationPerformer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    HashMap<Integer, Command> commands;

    public Menu() {
        this.commands = new HashMap<>();
    }

    public void addCommand(Integer number, Command command) {
        if (number != null && command != null) commands.put(number, command);
    }

    public void printMenu() {
        for (Map.Entry<Integer, Command> entry : commands.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getTitle());
        }
    }

    public static Menu getMainMenu() {
        Menu menu = new Menu();
        menu.addCommand(1, new StartNewCommand());
        menu.addCommand(2, new ContinueLastCommand());
        menu.addCommand(3, new StopCommand());
        return menu;
    }

    public void startMenu() {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (true) {
                    int answer = Integer.parseInt(reader.readLine());
                    if (!commands.containsKey(answer)) {
                        System.out.println("Command is not found");
                        continue;
                    }
                    commands.get(answer).execute();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public HashMap<Integer, Command> getCommands() {
        return commands;
    }

    public void clearMenu(){
        commands.clear();
    }
}
