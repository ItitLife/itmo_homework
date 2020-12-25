package exams.thirdFox.commands;

public class StopCommand implements Command {
    String title = "Stop";
    Menu menu;

    public StopCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void execute() {
        System.out.println("Game was ended.");
        menu.end();
    }
}
