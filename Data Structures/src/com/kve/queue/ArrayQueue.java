package com.kve.queue;

public class ArrayQueue {
	private int maxSize;
	private int front;
	private int rear;
	private int[] array;
	
	//���췽��
	public ArrayQueue(int max) {
		this.maxSize = max;
		array = new int[this.maxSize];
		front = -1;
		rear = -1;
	}
	
	//�ж��Ƿ���
	public boolean isFull() {
		if (this.rear == maxSize - 1) {
			return true;
		}
		return false;
	}
	
	//�ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		if (this.front == this.rear) {
			return true;
		}
		return false;
	}
	
	//add�����
	public void add(int i) {
		//�ж��Ƿ���
		if (this.isFull()) {
			System.out.println("Full!Can not add!");
			return;
		}
		rear++;
		array[rear] = i;
	}
	
	//remove������
	public int remove() {
		//�ж��Ƿ�Ϊ��
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
		//�ж��Ƿ�Ϊ��
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
