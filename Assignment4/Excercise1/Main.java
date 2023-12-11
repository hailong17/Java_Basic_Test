package Excercise1;

class Student {
    private String name;

    public Student() {
        this.name = "Unknown";
    }

    public Student(String name) {
        this.name = name;
    }

    public void printName() {
        System.out.println("Student name is: " + name);
    }
}

public class Main {
	public static void main(String[] args) {
		/* Creating an object of the class Student */
		Student student  = new Student();
		Student student1 = new Student("Long");
		student.printName();
		student1.printName();
	}
}
