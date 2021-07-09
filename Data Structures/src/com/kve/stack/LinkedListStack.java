package com.kve.stack;

//用单链表实现栈
//头插法

public class LinkedListStack {
	private SNode head = new SNode(null);
	
	//pop
	public int pop() {
		if (isEmpty()) {
			throw new RuntimeException("链表为空");
		}
		
		int i = head.next.data;
		head.next = head.next.next;
		
		return i;
	}
	
	
	//push
	//头插法
	public void push(int i) {
		SNode newNode = new SNode(i);
		newNode.next = head.next;
		
		head.next = newNode;
	}
	
	//isEmpty
	public boolean isEmpty() {
		return head.next == null;
	}
	
	
	//show
	public void show() {
		SNode temp = head.next;
		while (temp != null) {
			System.out.println(temp);
			temp = temp.next;
		}
	}
}

class SNode {
	Integer data;
	SNode next;
	
	public SNode(Integer data) {
		this.data = data;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return "data:" + data;
	}
}