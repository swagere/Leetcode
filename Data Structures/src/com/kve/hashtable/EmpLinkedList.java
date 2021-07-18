package com.kve.hashtable;

public class EmpLinkedList {
	Emp head;
	
	public EmpLinkedList() {
		this.head = new Emp(0,""); //����ͷ�ڵ� ����ֵ
	}
	
	//����һ���ڵ�
	//��˳������ ������ʱ
	public void add(Emp node) {
		int id = node.id;
		Emp temp = head;
		
		//�ҵ�Ӧ�ò����λ��
		while (temp != null && temp.next != null) {
			if (id >= temp.next.id) {
				temp = temp.next;
			}
			else {
				break;
			}
		}
		
		//���tempΪ���һ�� ��ô˵��nodeӦ�ò��뵽���
		if (temp.next != null) {
			node.next = temp.next; // �����Ϊ���һ�� �����뵽�м�
		}
		temp.next = node;
	}
	
	//��ʾһ������
	public void list() {
		Emp temp = head.next;
		while (temp != null) {
			System.out.print("=> id=" + temp.id + ",name=" + temp.name + "; ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	//����һ��Ԫ��
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
