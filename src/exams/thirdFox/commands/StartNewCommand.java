package exams.thirdFox.commands;

import exams.thirdFox.game.SituationPerformer;

public class StartNewCommand implements Command {
    String title = "New Game";
    Menu menu;

    public StartNewCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void execute() {
        SituationPerformer performer = new SituationPerformer(menu);
        performer.perform("///");
    }
}
