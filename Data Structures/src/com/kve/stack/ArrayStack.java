package com.kve.stack;


public class ArrayStack {
	private int maxSize;
	private int[] stack;
	private int top = -1;
	
	//构造器
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[maxSize];
	}
	
	//pop
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("栈为空");
		}
		
		int temp = stack[top];
		top--;
		return temp;
	}
	
	
	//push
	public void push(int i) {
		if (isFull()) {
			System.out.println("栈已满");
			return;
		}
		top++;
		stack[top] = i;
	}
	
	//isFull
	public boolean isFull() {
		return maxSize == top + 1;
	}
	
	//isEmpty
	public boolean isEmpty() {
		return top == -1;
	}
	
	//show 从后往前显示
	public void show() {
		if (!isEmpty()) {
			for (int temp = top; temp >= 0; temp--) {
				System.out.println("stack[" + temp + "]:" + stack[temp]);
			}
		}
	}
	
	
	
}
