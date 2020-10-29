package lesson15.hw;

import java.util.Collections;
import java.util.List;

public class EmployeeApp {

    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        Collections.sort(employees, new EmployeeNameComparator());
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("__________________");

        Collections.sort(employees, new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("__________________");

        Collections.sort(employees, new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()
                .thenComparing(new EmployeeAgeComparator().thenComparing(new EmployeeCompanyComparator()))));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("__________________");

    }
}
