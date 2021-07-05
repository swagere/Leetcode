package com.kve.linkedlist;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		singleLinkedList.addByOrder(new Node(1, "zhang3"));
		singleLinkedList.addByOrder(new Node(2, "li4"));
		singleLinkedList.addByOrder(new Node(3, "wang5"));
		singleLinkedList.show();
		System.out.println();
		
		singleLinkedList.update(new Node(2, "li4er"));
		singleLinkedList.show();
		System.out.println();
		
		singleLinkedList.remove(4);
//		singleLinkedList.remove(2);
//		singleLinkedList.remove(3);
		singleLinkedList.show();
		System.out.println();
	}

}
