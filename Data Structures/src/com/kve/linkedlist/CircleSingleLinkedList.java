package com.kve.linkedlist;

public class CircleSingleLinkedList {
	private static CNode first = null;
	
	//建立链表
	public void add(int num) {
		if (num < 1) {
			System.out.println("输入范围错误");
			return;
		}
		
		//建立单项循环链表
		CNode cur = null;
		for (int i = 1; i <= num; i++) {
			CNode newNode = new CNode(i);
			if (i == 1) {
				first = newNode;
				first.next = newNode;
				cur = first;
			}
			else {
				newNode.next = cur.next;
				cur.next = newNode;
			}
			cur = cur.next;	
		}
	}
	
	//显示此链表
	public void show() {
		CNode temp = first;
		while (temp.next != first) {
			System.out.println(temp);
			temp = temp.next;
		}
		System.out.println(temp);
	}

	//从开始报数
	//辅助节点指向环形链表的最后
	public static void out(int m) {
		if (m < 1) {
			System.out.println("输入范围有误");
			return;
		}
		int count = 1;
		CNode temp = getLastNode();
		CNode cur = temp.next;
		
		while (temp.next != temp) {
			if (count == m) {
				System.out.println(cur);
				temp.next = cur.next;
				cur = cur.next;
				count = 1;
			}
			else {
				temp = temp.next;
				cur = cur.next;
				count++;
			}
		}
		System.out.println(temp);
	}
	
	private static CNode getLastNode() {
		CNode temp = first;
		while (temp.next != first) {
			temp = temp.next;
		}
		return temp;
	}
	
	//从指定的节点开始报数
	//辅助节点指向开始的前一个
	public static void outByOrder(int start, int m) {
		if (start < 1 || m < 1) {
			System.out.println("输入范围有误");
			return;
		}
		
		int count = 1;
		CNode temp = getLastNode();
		CNode cur = temp.next;
		
		//找到最开始的位置
		while (start > 1) {
			temp = temp.next;
			cur = cur.next;
			start--;
		}
		
		//开始报数
		while (temp.next != temp) {
			if (count == m) {
				System.out.println(cur);
				temp.next = cur.next;
				cur = cur.next;
				count = 1;
			}
			else {
				temp = temp.next;
				cur = cur.next;
				count++;
			}
		}
		System.out.println(temp);
	}
}

class CNode {
	private int no;
	CNode next;
	
	//构造方法
	CNode(int no) {
		this.no = no;
	}
	
	@Override
	public String toString() {
		return "[" + "no:" + no + "]";
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public CNode getNext() {
		return next;
	}

	public void setNext(CNode next) {
		this.next = next;
	}
}
