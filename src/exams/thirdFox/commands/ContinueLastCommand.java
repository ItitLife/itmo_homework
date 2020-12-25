package exams.thirdFox.commands;

import exams.thirdFox.stategy.SituationPerformer;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class ContinueLastCommand implements Command {
    /*SituationPerformer performer;

    public ContinueLastCommand(SituationPerformer performer) {
        this.performer = performer;
    }*/

    String title = "Load Game";


    @Override
    public void execute() {
        File file = new File("savedgame.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (InputStream input = ContinueLastCommand.class.getClassLoader().getResourceAsStream("chat.properties")) {
           // file.(input);

        } catch (
                IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}
