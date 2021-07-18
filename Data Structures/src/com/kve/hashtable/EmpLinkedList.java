package com.kve.hashtable;

public class EmpLinkedList {
	Emp head;
	
	public EmpLinkedList() {
		this.head = new Emp(0,""); //链表头节点 不赋值
	}
	
	//新增一个节点
	//按顺序新增 即增加时
	public void add(Emp node) {
		int id = node.id;
		Emp temp = head;
		
		//找到应该插入的位置
		while (temp != null && temp.next != null) {
			if (id >= temp.next.id) {
				temp = temp.next;
			}
			else {
				break;
			}
		}
		
		//如果temp为最后一个 那么说明node应该插入到最后
		if (temp.next != null) {
			node.next = temp.next; // 如果不为最后一个 即插入到中间
		}
		temp.next = node;
	}
	
	//显示一个链表
	public void list() {
		Emp temp = head.next;
		while (temp != null) {
			System.out.print("=> id=" + temp.id + ",name=" + temp.name + "; ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//查找一个元素
	public void findById(int id) {
		Emp temp = head.next;
		Emp res = null;
		while (temp != null) {
			if (temp.id < id) {
				temp = temp.next;
			}
			else if (temp.id == id) {
				res = temp;
				break;
			}
			else {
				break;
			}
		}
		
		if (res == null) {
			System.out.println("wu");
		}
		else {
			System.out.println("id=" + temp.id + ",name=" + temp.name + "; ");
		}
	}
}
