package exams.thirdFox.commands;

import exams.thirdFox.game.SituationPerformer;

import java.io.*;

public class ContinueLastCommand implements Command {
    String title = "Load Game";
    SituationPerformer performer = new SituationPerformer();


    @Override
    public void execute() {
        File file = new File("savedgame.txt");
        String res;
        if (!file.exists()) {
            System.out.println("There is no saves");
            return;
        }
        try {
            try (FileInputStream inputStream = new FileInputStream(file);ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
                byte[] bytes = new byte[300];
                int data;
                while ((data = inputStream.read(bytes)) != -1) {
                    byteArray.write(bytes, 0, data);
                }
                res = new String(byteArray.toByteArray());
                performer.perform(res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getTitle() {
        return title;
    }
}
