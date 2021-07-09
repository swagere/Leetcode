package com.kve.stack;

//�õ�����ʵ��ջ
//ͷ�巨

public class LinkedListStack {
	private SNode head = new SNode(null);
	
	//pop
	public String pop() {
		if (isEmpty()) {
			throw new RuntimeException("����Ϊ��");
		}
		
		String i = head.next.data;
		head.next = head.next.next;
		
		return i;
	}
	
	
	//push
	//ͷ�巨
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
	
	//getPop���ջ��Ԫ��
	public String getPop() {
		if (isEmpty()) {
			return null;
		}
		return head.next.data;
	}

	//�Ƿ����1
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