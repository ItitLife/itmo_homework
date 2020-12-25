package exams.thirdFox.stategy;
/**
 * @class contains info about situation
 */
public class Situation {
    /**
     * @param title would be used like a key in HashMap in StoryBuilder
     * @param description describe situation
     * @param vars contains variants for next Situation, if it's not null in every var must contains title of
     *             other Situation, because SituationPerformer choose next Situation by contains*/
    private String title;
    private String description;
    private String[] vars;

    /**
     * @Constructor for Situations whit opportunities*/
    public Situation(String title, String description, String[] vars) {
        this.title = title;
        this.description = description;
        this.vars = vars;
    }
    /**
     * @Constructor for endSituations*/
    public Situation(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;

    }

    public String[] getVars() {
        return vars;
    }


}
