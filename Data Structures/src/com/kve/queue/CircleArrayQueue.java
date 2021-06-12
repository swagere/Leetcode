package com.kve.queue;

public class CircleArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] array;
	
	public CircleArrayQueue(int max) { //构造方法无返回类型
		this.maxSize = max;
		array = new int[this.maxSize];
		front = 0;
		rear = 0;
	}
	
	public boolean isFull() {
		if ((rear + 1) % maxSize == front) {
			return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if (rear == front) {
			return true;
		}
		return false;
	}
	
	public int size() {
		return (rear + this.maxSize - front) % this.maxSize;
	}
	
	public void add(int i) {
		if (isFull()) {
			System.out.println("Full!Can not add!");
			return;
		}
		array[rear] = i;
		rear = (rear + 1) % this.maxSize;
	}
	
	public int remove() {
		if (this.isEmpty()) {
			System.out.println("Empty!Can not remove!");
			return -1;
		}
		int value = array[front];
		front = (front + 1) % this.maxSize;
		return value;
	}
	
	public String toString() {
		if (this.isEmpty()) {
			return "Empty!";
		}
		String s = new String();
		for (int i = front; i <= this.size(); i++) {
			s = s + array[i % this.maxSize] + "\n";
		}
		return s;
	}
}
