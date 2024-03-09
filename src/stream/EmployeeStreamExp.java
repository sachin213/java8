package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeStreamExp {
    public static void main(String[] args) {

        List<Employee> empList = Employee.getEmployeeList();

        //get count of male,female Employee
        Map<String,Long> empByGender = empList.stream().collect(Collectors.groupingBy(Employee::getGender , Collectors.counting()));
        System.out.println(empByGender);

        //Write a program to print the names of all departments in the organization.
        Set<String> departmentSet = empList.stream().map(employee -> employee.getDepartment()).collect(Collectors.toSet());

        // Find the average age of Male and Female Employees.
        Map<String, Double> empAverageAgeByGender = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender , Collectors.averagingLong(Employee::getAge)));

        //Get the Names of employees who joined after 2015.
        List<String> empNameAfterJoin2015 = empList.stream().filter(emp -> emp.yearOfJoining > 2015).map(employee -> employee.getName()).toList();

        //Count the number of employees in each department.
         Map<String,Long> empCountByDepartment = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        //Find out the average salary of each department
        Map<String,Double> empSalaryByDepartment = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        // Find out the oldest employee, his/her age and department?
        Employee oldestEmp = empList.stream().sorted(Comparator.comparing(Employee :: getAge , Comparator.reverseOrder())).findFirst().get();
        System.out.println(oldestEmp);
        Employee oldestEmp1 = empList.stream().max(Comparator.comparing(Employee::getAge)).get();

        // Find out the average and total salary of the organization.
        Double avgSalary = empList.stream().collect(Collectors.summarizingDouble(Employee :: getSalary)).getAverage();
        Double salarySum = empList.stream().collect(Collectors.summarizingDouble(Employee :: getSalary)).getSum();

        //List down the employees of each department.
        Map<String,List<Employee>> departmentWiseDepList = empList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
      //  departmentWiseDepList.entrySet().stream().forEach(entrySet -> entrySet.getValue().stream().forEach(System.out::println));


        //Find out the highest experienced employees in the organization
        Employee employeeWithHighestEmp = empList.stream().sorted(Comparator.comparing(Employee :: getYearOfJoining)).findFirst().get();
        System.out.println(employeeWithHighestEmp);
        Employee employeeWithHighestEmp1 = empList.stream().min(Comparator.comparing(Employee :: getYearOfJoining)).get();
        System.out.println(employeeWithHighestEmp);
    }
}
