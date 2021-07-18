package com.kve.hashtable;

public class EmpHashTable {
	int size;
	EmpLinkedList[] empLinkedLists;
	
	public EmpHashTable(int size) {
		this.size = size;
		empLinkedLists = new EmpLinkedList[size];
		
		//ע���ʼ��ÿ������
		for (int i = 0; i < size; i++) {
			empLinkedLists[i] = new EmpLinkedList();
		}
	}
	
	//����
	public void add(Emp node) {
		int hash = hash(node.id);
		empLinkedLists[hash].add(node);
	}
	
	
	//hash�㷨���˴��ü򵥵�ȡģ����
	private int hash(int id) {
		return id % size;
	}

	//��ʾ
	public void list() {
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + ": ");
			empLinkedLists[i].list();
		}
	}
	
	//����һ��Ԫ��
	public void findById(int id) {
		int hash = hash(id);
		empLinkedLists[hash].findById(id);
	}
}
