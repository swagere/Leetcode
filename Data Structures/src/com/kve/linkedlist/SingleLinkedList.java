package com.kve.linkedlist;

//������
public class SingleLinkedList {
	private Node head = new Node(0, ""); //ͷ�ڵ� ���ɸı�
	
	public SingleLinkedList(Node head) {
		this.head = head;
	}
	
	public SingleLinkedList() {}

	//β�巨���
	public void add(Node node) {
		Node temp = head; //�����ڵ� �������б���
		
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
	}
	
	//��˳�����
	public void addByOrder(Node node) {
		//ע����ҵ���ӵ�ǰһ��
		Node temp = head;
		boolean flag = false;
		
		while(true) {
			if (temp.next == null) {
				break;
			}
				
			if (temp.next.no > node.no) {
				break;
			}
			else if (temp.next.no == node.no) {
				flag = true;
				break;
			}
			
			
			temp = temp.next;
		}
		
		if (flag == true) {
			System.out.println("Ҫ�����Ԫ�����ظ�");
		}
		else {
			node.next = temp.next;
			temp.next = node;
		}
	}
	
	//�޸�һ���ڵ�
	public void update(Node node) {
		Node temp = head;
		boolean flag = false;
		
		while(true) {
			if (temp.next == null) {
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
		Node temp = head;
		boolean flag = false;
		
		while (true) {
			if (temp.next == null) {
				break;
			}
			
			if (temp.next.no == index) {
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		
		if (flag == true) {
			//ɾ���ڵ�
			temp.next = temp.next.next;
		}
		else {
			System.out.println("�ýڵ㲻���� ɾ��ʧ��");
		}
	}
	
	//������ʾ
	public void show() {
		Node temp = head.next; //�����ڵ� �������б���
		
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

	//���ͷ�ڵ�
	public Node getHead() {
		return head;
	}
}

//����ڵ�
//data node
class Node {
	Integer no;
	String name;
	Node next;
	
	
	//���췽��
	public Node(Integer no, String name) {
		this.no = no;
		this.name = name;
		this.next = null;
	}
	
	@Override
	public String toString() {
		return "[no:" + no + "; name:" + name + "]"; 
	}
	
}
