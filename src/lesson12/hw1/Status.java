package lesson12.hw1;

/*
*/
public enum Status {
    FILE_NOT_FOUND, ACCESS_DENIED, JAR_ERROR;

    public static Status getRandomStatus() {
        int r = (int) (Math.random() * 3);
        if (r == 0)
            return Status.FILE_NOT_FOUND;
        if (r == 1)
            return Status.ACCESS_DENIED;
        if (r == 2)
            return Status.JAR_ERROR;
        return Status.JAR_ERROR;
    }
}
