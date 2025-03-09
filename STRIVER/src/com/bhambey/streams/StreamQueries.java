package com.bhambey.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Queue;
import java.util.stream.Collectors;

import javax.swing.tree.TreeNode;

public class StreamQueries {

	public static void main(String[] args) {

		List<Employee> list = new ArrayList<>();

		list.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		list.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		list.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		list.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		list.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		list.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		list.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		list.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		list.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		list.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		list.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		list.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		list.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		list.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		list.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		list.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		list.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		// Number of Male and Female employees
		Map<String, Long> numberOfMaleAndFemaleEmployees = list.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println(numberOfMaleAndFemaleEmployees);

		System.out.println("-------------------------------------------");

		// Get departments
		list.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		System.out.println("-------------------------------------------");

		// Average age of male and female employees
		Map<String, Double> averageAgeOfMaleAndFemaleEmployees = list.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));

		System.out.println(averageAgeOfMaleAndFemaleEmployees);

		System.out.println("-------------------------------------------");

		// Highest Paid Employee
		Optional<Employee> highestPaidEmployee = list.stream().max(Comparator.comparingDouble(Employee::getSalary));

		System.out.println("Highest Paid Employee: " + highestPaidEmployee);

		System.out.println("-------------------------------------------");

		// Top three highest paid employees
		System.out.println("TOP 3 HIGHEST PAID EMPLOYEES: ");
		list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
				/* .map(Employee::getName) */.limit(3).forEach(System.out::println);

		System.out.println("-------------------------------------------");

		// Employees who joined after 2015
		System.out.println("EMPLOYEES WHO JOINED AFTER 2015: ");
		list.stream().filter(e -> e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);

		System.out.println("-------------------------------------------");

		// Employee Count By Department
		Map<String, Long> employeeCountByDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

		System.out.println("EMPLOYEE COUNT BY DEPARTMENT:");
		System.out.println(employeeCountByDepartment);

		System.out.println("-------------------------------------------");

		// Average Salary Of Departments
		Map<String, Double> averageSalaryOfDepartments = list.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

		System.out.println("AVERAGE SALARY OF DEPARTMENTS: ");

		averageSalaryOfDepartments.forEach((k, v) -> System.out.println(k + " : " + v));

//		for (Map.Entry<String, Double> m : averageSalaryOfDepartments.entrySet()) {
//			System.out.println(m.getKey() + " : " + m.getValue());
//		}
		// System.out.println(averageSalaryOfDepartments);

		System.out.println("-------------------------------------------");

		// Youngest male employee in ProductDevelopment department
		Optional<Employee> youngestInProductDevelopment = list.stream()
				.filter(e -> e.getGender() == "Male" && e.getDepartment() == "Product Development")
				.min(Comparator.comparingInt(Employee::getAge));

		System.out.println("Youngest Employee in Product Development Department:");

		System.out.println(youngestInProductDevelopment.get().getName());

		System.out.println("-------------------------------------------");

		// Senior Most Employee
		Optional<Employee> seniorMostEmployee = list.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));

		System.out.println("Senior Most Employee: " + seniorMostEmployee.get().getName());

		System.out.println("-------------------------------------------");

		// Count Male and Female Employees in Sales Marketing
		Map<String, Long> maleFemaleInSalesMarketing = list.stream()
				.filter(e -> e.getDepartment() == "Sales And Marketing")
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.println("male and Female Employees in Sales and Marketing" + maleFemaleInSalesMarketing);

		System.out.println("-------------------------------------------");

		// Average Salary of Male and Female employees
		Map<String, Double> avergeSalaryMaleFemaleEmployees = list.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average salary of male and female employees: " + avergeSalaryMaleFemaleEmployees);

		System.out.println("-------------------------------------------");

		// Employee List By Department
		Map<String, List<Employee>> employeeByDepartment = list.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment));
		System.out.println("Employee List By Department: " + employeeByDepartment);

		System.out.println("-------------------------------------------");

		// Employee Salary Statistics
		DoubleSummaryStatistics salaryStatistics = list.stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));

		System.out.println("Average Employee Salary: " + salaryStatistics.getAverage());
		System.out.println("Total Salary: " + salaryStatistics.getSum());
		System.out.println(salaryStatistics);
//
//		IntSummaryStatistics iss = list.stream().collect(Collectors.summarizingInt(Employee::getAge));
//		System.out.println(iss);

		System.out.println("-------------------------------------------");

		// Partition Employees By Age
		Map<Boolean, List<Employee>> partitionByAge = list.stream()
				.collect(Collectors.partitioningBy(e -> e.getAge() > 25));
		System.out.println("Partitioned By Age: " + partitionByAge);

		System.out.println("-------------------------------------------");

		List<Employee> aboveTwentyFiveList = list.stream().filter(e -> e.getAge() > 25).collect(Collectors.toList());

		System.out.println("ABOVE 25 YOA: " + aboveTwentyFiveList);

		System.out.println("-------------------------------------------");

		// Oldest Employee
		Optional<Employee> oldestEmployee = list.stream().min(Comparator.comparingInt(Employee::getYearOfJoining));
		System.out.println("Oldest Employee: " + oldestEmployee);

		System.out.println("-------------------------------------------");

		// All Female Employees
		List<Employee> allFemaleEmployees = list.stream().filter(e -> e.getGender() == "Female")
				.collect(Collectors.toList());

		System.out.println("ALL FEMALE EMPLOYEES: " + allFemaleEmployees);

		System.out.println("-------------------------------------------");

		// Collecting to Map
		Map<String, Double> collectedToMap = list.stream()
				.collect(Collectors.toMap(Employee::getName, Employee::getSalary));

		System.out.println(collectedToMap);

	}

}
