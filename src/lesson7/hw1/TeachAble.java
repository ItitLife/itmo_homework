package lesson7.hw1;

public interface TeachAble {
    default void teach(StudyAble student){
        student.study();
    };
}

