package com.kve.linkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		
		//add
		doubleLinkedList.add(new DNode(1, "zhang3"));
		doubleLinkedList.add(new DNode(20, "li4"));
		doubleLinkedList.add(new DNode(30, "wang5"));
		doubleLinkedList.addByOrder(new DNode(10, "hu10"));
		doubleLinkedList.show();
		System.out.println();

		doubleLinkedList.update(new DNode(10, "hu1"));
		doubleLinkedList.show();
		System.out.println();
		
		doubleLinkedList.remove(20);
		doubleLinkedList.show();
		System.out.println();
	}

}
