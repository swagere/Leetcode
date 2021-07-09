package com.kve.stack;

//用单链表实现栈
//头插法

public class LinkedListStack {
	private SNode head = new SNode(null);
	
	//pop
	public String pop() {
		if (isEmpty()) {
			throw new RuntimeException("链表为空");
		}
		
		String i = head.next.data;
		head.next = head.next.next;
		
		return i;
	}
	
	
	//push
	//头插法
	public void push(String i) {
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
	
	//getPop获得栈顶元素
	public String getPop() {
		if (isEmpty()) {
			return null;
		}
		return head.next.data;
	}

	//是否大于1
	public boolean GthanOne() {
		if (head.next.next != null) {
			return true;
		}
		return false;
	}
}

class SNode {
	String data;
	SNode next;
	
	public SNode(String data) {
		this.data = data;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return "data:" + data;
	}
}