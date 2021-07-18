package com.kve.hashtable;

public class EmpHashTable {
	int size;
	EmpLinkedList[] empLinkedLists;
	
	public EmpHashTable(int size) {
		this.size = size;
		empLinkedLists = new EmpLinkedList[size];
		
		//注意初始化每个链表
		for (int i = 0; i < size; i++) {
			empLinkedLists[i] = new EmpLinkedList();
		}
	}
	
	//新增
	public void add(Emp node) {
		int hash = hash(node.id);
		empLinkedLists[hash].add(node);
	}
	
	
	//hash算法：此处用简单的取模运算
	private int hash(int id) {
		return id % size;
	}

	//显示
	public void list() {
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + ": ");
			empLinkedLists[i].list();
		}
	}
	
	//查找一个元素
	public void findById(int id) {
		int hash = hash(id);
		empLinkedLists[hash].findById(id);
	}
}
