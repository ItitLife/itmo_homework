package exams.firstFitness;

class NamesAndSernames {
    static String getName(){
        String[] names = new String[]{"ivan", "petr", "nikolay", "stepan", "fedor", "savva", "georg", "iren", "maria", "anna", "lisa", "ksenia", "valerii"};
        return names[(int) (Math.random() * names.length)];
    }

    static String getSername(){
        String[] names = new String[]{"petrov", "sidorov", "ivanov", "kuznecov", "melnikov", "kovalenko", "smit", "yarmolenko", "valiliyev", "abramov"};
        return names[(int) (Math.random() * names.length)];
    }

}