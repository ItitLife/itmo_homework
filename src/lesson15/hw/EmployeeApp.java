package lesson15.hw;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class EmployeeApp {

    public static void main(String[] args) {
        List<Employee> employees = Employee.employeeGenerator(20);
        Collections.sort(employees, new EmployeeNameComparator());
        Consumer<List<Employee>> print = list -> list.forEach(employee -> System.out.println(employee));
        /*for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("__________________");*/
        employees.sort((e1, e2) -> e1.getName().compareTo(e2.getName()));
        print.accept(employees);

        /*Collections.sort(employees, new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("__________________");*/


        Collections.sort(employees, new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator()
                .thenComparing(new EmployeeAgeComparator().thenComparing(new EmployeeCompanyComparator()))));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println("__________________");

    }
}
