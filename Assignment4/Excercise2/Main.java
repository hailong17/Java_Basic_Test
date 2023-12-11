package Excercise2;

abstract class Parent {
	public void message() {}
}

class subClass1 extends Parent{
	public void message() {
		System.out.println("This is first subclass");
	}
}

class subClass2 extends Parent{
	public void message() {
		System.out.println("This is second subclass");
	}
}

public class Main {
	public static void main(String[] args) {
		subClass1 sub1 = new subClass1();
		subClass2 sub2 = new subClass2();

		sub1.message();
		sub2.message();
	}
}

