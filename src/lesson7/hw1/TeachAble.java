package lesson7.hw1;

public interface TeachAble {
    default void teach(Student student){
        student.study();
    };
}

