package com.kve.linkedlist;

//Լɪ������
public class JosephDemo {
	public static void main(String[] args) {
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.add(5);
		circleSingleLinkedList.show();
		System.out.println();
		
//		circleSingleLinkedList.out(2);
		
		circleSingleLinkedList.outByOrder(2, 2);
		
	}
}
