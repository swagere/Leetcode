package com.kve.queue;

public class ArrayQueueDemo {

	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		arrayQueue.add(1);
		arrayQueue.add(2);
		arrayQueue.add(3);
		arrayQueue.remove();
		arrayQueue.add(4);
		System.out.println(arrayQueue.toString());
	}

}
