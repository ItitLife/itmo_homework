package exams.thirdFox.commands;

import exams.thirdFox.game.SituationPerformer;

import java.io.*;

public class LoadCommand implements Command {
    String title = "Load Game";
    Menu menu;
    SituationPerformer performer;

    public LoadCommand(Menu menu) {
        this.menu = menu;
        this.performer = new SituationPerformer(menu);
    }

    @Override
    public void execute() {
        performer.load();
    }

    @Override
    public String getTitle() {
        return title;
    }
}
