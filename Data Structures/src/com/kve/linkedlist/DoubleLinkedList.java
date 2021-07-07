package com.kve.linkedlist;

public class DoubleLinkedList {
	private DNode head = new DNode(0, ""); //ͷ�ڵ� ���ɸı�
	
	//���췽��
	public DoubleLinkedList(DNode head) {
		this.head = head;
	}
	
	public DoubleLinkedList() {}
	
	//β�巨���
	public void add(DNode node) {
		DNode temp = head; //�����ڵ� �������б���
		
		//ѭ���ҵ�β�ڵ�
		while (true) {
			if (temp.next == null) {
				//�ҵ�β�ڵ�
				break;
			}
			
			//û���ҵ�β�ڵ�
			temp = temp.next;
		}
		
		//����
		temp.next = node;
		node.pre = temp;
	}
	
	//������ʾ
	public void show() {
		DNode temp = head.next; //�����ڵ� �������б���
		
		//ѭ���ҵ�β�ڵ�
		while (true) {
			if (temp == null) {
				//�ҵ�β�ڵ�
				break;
			}
			
			//û���ҵ�β�ڵ� �ʹ�ӡ�ýڵ�
			System.out.println(temp);
			temp = temp.next;
		}
		
	}
	
	//��˳�����
	public void addByOrder(DNode node) {
		//ֱ�Ӳ��ҵ���Ҫ��ӵ���һ��
		DNode temp = head;
		boolean flag = false; //����Ƿ��ظ�
		
		while(true) {
			if (temp == null) {
				break;
			}
				
			if (temp.no > node.no) {
				break;
			}
			else if (temp.no == node.no) {
				flag = true;
				break;
			}
			
			
			temp = temp.next;
		}
		
		if (flag == true) {
			System.out.println("Ҫ�����Ԫ�����ظ�");
		}
		else {
			node.next = temp;
			node.pre = temp.pre;
			temp.pre.next = node;
			temp.pre = node;
		}
	}
	
	//�޸�һ���ڵ�
	public void update(DNode node) {
		DNode temp = head;
		boolean flag = false;
		
		while(true) {
			if (temp == null) {
				break;
			}
			if (temp.no == node.no) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		
		if (flag == true) {
			//����
			temp.name = node.name;
		}
		else {
			System.out.println("�ýڵ㲻���� �޷��޸�");
		}
	}
	
	//ɾ��һ���ڵ�
	public void remove(int index) {
		//���ҵ�Ҫɾ���ڵ��ǰһ���ڵ�
		DNode temp = head;
		boolean flag = false;
		
		while (true) {
			if (temp == null) {
				break;
			}
			
			if (temp.no == index) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		
		if (flag == true) {
			//ɾ���ڵ�
			
			temp.pre.next = temp.next;
			
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		}
		else {
			System.out.println("�ýڵ㲻���� ɾ��ʧ��");
		}
	}


	
}

//����ڵ�
//data node
class DNode {
	Integer no;
	String name;
	DNode next;
	DNode pre;
	
	
	//���췽��
	public DNode(Integer no, String name) {
		this.no = no;
		this.name = name;
		this.next = null;
		this.pre = null;
	}
	
	@Override
	public String toString() {
		return "[no:" + no + "; name:" + name + "]"; 
	}
}