package lesson15.hw;// Создать список объетов List<Employee> (использовать метод employeeGenerator)
// и сортировать по:
// имени
// имени и зарплате
// имени, зарплате, возрасту и компании

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;

    // TODO: конструктор, геттеры и сеттеры


    private Employee(String name, String company, int salary, int age) {
        setName(name);
        setCompany(company);
        setSalary(salary);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.length() < 3) {
            throw new IllegalArgumentException("Имя должно быть больше 3х символов");
        }
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    private void setCompany(String company) {
        if (company == null || company.length() < 3) {
            throw new IllegalArgumentException("Название компании должно быть больше 3х символов");
        }
        this.company = company;
    }

    public int getSalary() {
        return salary;
    }

    private void setSalary(int salary) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Зарплата должна быть больше 0");
        }
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    private void setAge(int age) {
        if (age <= 20) {
            throw new IllegalArgumentException("Возраст должен быть больше 20");
        }
        this.age = age;
    }

    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(names[(int) (Math.random()*names.length)],
                    companies[(int) (Math.random()*companies.length)],
                    1 + (int) (Math.random()*100),
                    21 + (int) (Math.random()*40)));
            // TODO: объекты создавать с рандомными значениями. Возраст от 21 до 60 и не забудьте про зп
        }
        return employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary &&
                age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(company, employee.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company, salary, age);
    }

    @Override
    public String toString() {
        return "Работник{" +
                "Имя: '" + name + '\'' +
                ", Компания: '" + company + '\'' +
                ", Возраст: " + age +
                ", Зарплата=" + salary +
                '}';
    }
}

class EmployeeNameComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getName().compareTo(e2.getName());
    }
}

class EmployeeCompanyComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.getCompany().compareTo(e2.getCompany());
    }
}

class EmployeeSalaryComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getSalary(),e2.getSalary());
    }
}

class EmployeeAgeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee e1, Employee e2) {
        return Integer.compare(e1.getAge(),e2.getAge());
    }
}