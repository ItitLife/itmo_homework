package exams.thirdFox.commands;

import exams.thirdFox.game.SituationPerformer;

public class VariantCommand implements Command {
    SituationPerformer performer;
    String title;

    public VariantCommand(SituationPerformer performer, String title) {
        this.performer = performer;
        this.title = title;
    }

    @Override
    public void execute() {
        performer.perform(title);
    }
    @Override
    public String getTitle() {
        return title;
    }
}
