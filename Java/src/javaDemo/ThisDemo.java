package javaDemo;

public class ThisDemo {
	public static void main(String[] args) {
		User user = new User();
		user.print();
	}

	public static void print() {
		System.out.println("hello");

	}

}

class User {
	public void print() {
		ThisDemo.print();
	}
}
