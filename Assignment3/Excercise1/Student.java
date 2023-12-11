package Excercise1;

public class Student {
	String name;
	int    rool_no;
	public static void main(String[] args) {
		/* Creating an object of the class Student */
		Student student = new Student();
		/* Assign the value for each attribute */
		student.name    = "John";
		student.rool_no = 2;

		System.out.println(student.name);
		System.out.println(student.rool_no);
	}
}
