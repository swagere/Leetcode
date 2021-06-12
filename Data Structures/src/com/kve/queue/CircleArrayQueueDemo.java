package com.kve.queue;

public class CircleArrayQueueDemo {

	public static void main(String[] args) {
		CircleArrayQueue circleArrayQueue = new CircleArrayQueue(4);
		circleArrayQueue.add(1);
		circleArrayQueue.add(2);
		circleArrayQueue.add(3);
		circleArrayQueue.remove();
		System.out.println(circleArrayQueue.toString());
	}

}
