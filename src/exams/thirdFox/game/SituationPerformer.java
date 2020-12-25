package exams.thirdFox.game;

import exams.thirdFox.commands.Menu;
import exams.thirdFox.commands.SaveCommand;
import exams.thirdFox.commands.StopCommand;
import exams.thirdFox.commands.VariantCommand;


import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class SituationPerformer {
    private HashMap<String, Situation> story = StoryBuilder.getStory();
    private Menu menu;
    private StopCommand exit;
    private SaveCommand save;
    private String currentTitle = "";

    public SituationPerformer(Menu menu) {
        this.menu = menu;
        this.exit = new StopCommand(menu);
        this.save = new SaveCommand(this);
    }

    public void perform(String title) {
        if (title == null || title == "&?&") {
            System.out.println("Situation wasn't found. New game started.");
            title = "///";
        }
        currentTitle = title;
        Situation first = story.get(currentTitle);
        System.out.println(first.getTitle() + "\n");
        System.out.println(first.getDescription());
        menu.clearMenu();
        if (first.getVars() != null) {
            String[] vars = first.getVars();
            System.out.println("Введи: ");
            for (int i = 0; i < vars.length; i++) {
                VariantCommand newVar = new VariantCommand(this, getTitle(vars[i]));
                menu.addCommand(i + 1, newVar);
            }
        }
        menu.addCommand(menu.getCommands().size() + 1, save);
        menu.addCommand(menu.getCommands().size() + 1, exit);
        menu.printMenu();
        menu.startMenu();
    }

    String getTitle(String var) {
        String title = "&?&";
        for (String s : story.keySet()) {
            if (var.contains(s)) {
                title = s;
                break;
            }
        }
        return title;
    }

    public void save() {
        File file = new File("resources/savedgame.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (FileWriter writer = new FileWriter(file, false)) {
            writer.write(currentTitle);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try (FileReader reader = new FileReader("resources/savedgame.txt")) {
            String title = "";
            char[] buf = new char[256];
            int c;
            while ((c = reader.read(buf)) > 0) {
                if (c < 256) {
                    buf = Arrays.copyOf(buf, c);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (char c1 : buf) {
                stringBuilder.append(c1);
            }
            title = stringBuilder.toString();
            this.perform(title);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
