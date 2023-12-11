package Excercise3;

import java.util.Scanner;

public class Employee {
    private String name;
    private int yearOfJoining;
    private String address;

    public Employee(String name, int yearOfJoining, String address) {
        this.name          = name;
        this.yearOfJoining = yearOfJoining;
        this.address       = address;
    }

    public void printEmployeeInfo() {
        System.out.println(name + " " + yearOfJoining + " " + address);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();

        Employee[] employees = new Employee[numEmployees];

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter infomation for Employee " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Year of joining: ");
            int yearOfJoining = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Address: ");
            String address = scanner.nextLine();

            employees[i] = new Employee(name, yearOfJoining, address);
        }

        System.out.println("\nEmployee Information:");
        System.out.println("Name\tYear of Joining\tAddress");

        for (Employee employee : employees) {
            employee.printEmployeeInfo();
        }

        scanner.close();
    }
}
