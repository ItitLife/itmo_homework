package lesson7.hw1;

public class Application {
    public static void main(String[] args) {
        Director newDirector = new Director();
        School newSchool = new School("№29", newDirector);
        newSchool.addStudents();
        newSchool.addTeachers();
        newSchool.studentsInfo();
        newSchool.teachersInfo();
        newDirector.startDay(newSchool);
        newSchool.newDay();
        newDirector.finishDay();
        newSchool.studyLevelInfo();
    }
}
