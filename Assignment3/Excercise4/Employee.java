package Excercise4;

import java.util.Scanner;

public class Employee {
    private float salary;
    private float hours;

    public void getInfo(float salary, float hours) {
        this.salary = salary;
        this.hours  = hours;
    }

    public void getInfo() {
        System.out.println("Salary is :" + salary);
        System.out.println("Hours Worked is :" + hours);
    }

    public void addSal() {
        if (salary < 500) {
            salary += 10;
        }
    }

    public void addWork() {
        if (hours > 6) {
            salary += 5;
        }
    }

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter salary: ");
		float salary  = scanner.nextFloat();
		System.out.println("Enter hours per day: ");
		float hours = scanner.nextFloat();
		scanner.close();

		Employee employee = new Employee();
		employee.getInfo(salary, hours);
		employee.addSal();
		employee.addWork();
		System.out.println("Final Salary is :" + employee.salary);
	}
}
