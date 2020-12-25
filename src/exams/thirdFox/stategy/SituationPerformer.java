package exams.thirdFox.stategy;

import exams.thirdFox.commands.Menu;
import exams.thirdFox.commands.SaveCommand;
import exams.thirdFox.commands.StopCommand;
import exams.thirdFox.commands.VariantCommand;
import exams.thirdFox.stategy.Situation;
import exams.thirdFox.stategy.StoryBuilder;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SituationPerformer {
    private HashMap<String, Situation> story = StoryBuilder.getStory();
    Scanner scanner = new Scanner(System.in);
    Menu menu = new Menu();
    StopCommand exit = new StopCommand();
    SaveCommand save = new SaveCommand(this);

    public void perform(String title) {
        if (title == "&?&") throw new IllegalArgumentException("Не найдена следующая ситуация");
        String newTitle = title;
        Situation first = story.get(title);
        System.out.println(first.getTitle() + "\n");
        System.out.println(first.getDescription());
        if (first.getVars() != null) {
            String[] vars = first.getVars();
            menu.clearMenu();
            System.out.println("Введи: ");
            for (int i = 0; i < vars.length; i++) {
                VariantCommand newVar = new VariantCommand(this, getTitle(vars[i]));
                menu.addCommand(i + 1, newVar);
                /*System.out.print(i + 1);
                System.out.println(" - " + newVar.getTitle());*/
                /*System.out.print(i + 1);
                System.out.println(" - " + vars[i]);*/
            }
        }
        menu.addCommand(menu.getCommands().size() + 1, save);
        menu.addCommand(menu.getCommands().size() + 1, exit);
        menu.printMenu();
        menu.startMenu();
            /*int var = scanner.nextInt();
            perform(getTitle(vars[var - 1]));*/


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

    }


}
