package com.kve.stack;

public class ArrayStackDemo {

	public static void main(String[] args) {
		ArrayStack arrayStack = new ArrayStack(3);
		arrayStack.push(1);
		arrayStack.push(2);
		arrayStack.push(3);
		
		
		arrayStack.pop();
		arrayStack.push(4);
		
		arrayStack.show();

	}

}
