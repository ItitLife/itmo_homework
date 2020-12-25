package exams.thirdFox.commands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private HashMap<Integer, Command> commands;
    private boolean end = false;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Menu() {
        this.commands = new HashMap<>();
    }

    public void end() {
        this.end = true;
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        menu.addCommand(1, new StartNewCommand(menu));
        menu.addCommand(2, new LoadCommand(menu));
        menu.addCommand(3, new StopCommand(menu));
        return menu;
    }

    public void startMenu() {
        try {
            while (!end) {
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

    public void clearMenu() {
        commands.clear();
    }
}
