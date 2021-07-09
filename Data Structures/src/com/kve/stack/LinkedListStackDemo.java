package com.kve.stack;

public class LinkedListStackDemo {

	public static void main(String[] args) {
		LinkedListStack linkedListStack = new LinkedListStack();
		linkedListStack.push("1");
		linkedListStack.push("2");
		linkedListStack.push("3");
		linkedListStack.push("10");
		linkedListStack.show();
		System.out.println();
		
		
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
		System.out.println(linkedListStack.pop());
//		System.out.println(linkedListStack.pop());
		System.out.println();
		
		linkedListStack.push("4");
		linkedListStack.show();

	}

}
