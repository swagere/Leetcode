package com.kve.queue;

public class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] array;
	
	//构造方法
	public ArrayQueue(int max) {
		this.maxSize = max;
		array = new int[this.maxSize];
		front = -1;
		rear = -1;
	}
	
	//判断是否满
	public boolean isFull() {
		if (this.rear == maxSize - 1) {
			return true;
		}
		return false;
	}
	
	//判断是否为空
	public boolean isEmpty() {
		if (this.front == this.rear) {
			return true;
		}
		return false;
	}
	
	//add入队列
	public void add(int i) {
		//判断是否满
		if (this.isFull()) {
			System.out.println("Full!Can not add!");
			return;
		}
		rear++;
		array[rear] = i;
	}
	
	//remove出队列
	public int remove() {
		//判断是否为空
		if (this.isEmpty()) {
			System.out.println("Empty!");
			return -1;
		}
		int value = array[front + 1];
		front++;
		return value;
	}
	
	//toString
	public String toString() {
		//判断是否为空
		if (this.isEmpty()) {
			return "Empty!";
		}
		String s = "";
		for (int i = front + 1; i <= rear; i++) {
			s = s + "\n" + array[i];
		}
		return s;
	}
}
