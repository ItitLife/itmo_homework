package lesson7.hw1;

public class NamesAndSubjects {
    public static String getName(){
        String[] names = new String[]{"ivan", "petr", "nikolay", "stepan", "fedor", "savva", "georg", "iren", "maria", "anna", "lisa", "ksenia", "valeryi"};
        return names[(int) (Math.random() * names.length)];
    }
    public static String getSubject(){
        String[] subjects = new String[]{"math", "geography", "geography", "life safety", "biology", "chemistry", "physics"};
        return subjects[(int) (Math.random() * subjects.length)];
    }
}