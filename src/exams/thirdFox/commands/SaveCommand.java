package exams.thirdFox.commands;

import exams.thirdFox.game.SituationPerformer;

public class SaveCommand implements Command {
    SituationPerformer performer;
    String title = "Save Game";

    public SaveCommand(SituationPerformer performer) {
        this.performer = performer;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void execute() {
        performer.save();
    }
}
