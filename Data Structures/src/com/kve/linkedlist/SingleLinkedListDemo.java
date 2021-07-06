package com.kve.linkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		//add addByOrder
		singleLinkedList.add(new Node(10, "hu10"));
		singleLinkedList.addByOrder(new Node(1, "zhang3"));
		singleLinkedList.addByOrder(new Node(2, "li4"));
		singleLinkedList.addByOrder(new Node(3, "wang5"));
		singleLinkedList.show();
		System.out.println();
		
		//update
		singleLinkedList.update(new Node(2, "li4er"));
		singleLinkedList.show();
		System.out.println();
		
		//remove
//		singleLinkedList.remove(1);
//		singleLinkedList.remove(2);
//		singleLinkedList.remove(3);
		singleLinkedList.show();
		System.out.println();
		
		//getLength()
		System.out.println("length:" + getLength(singleLinkedList.getHead()));
		
		//getLastIndexNode()
		int index = 3;
		Node res = getLastIndexNode(singleLinkedList.getHead(), index);
		if (res == null || res.no == 0) {
			System.out.println("����ʧ��");
		}
		else {
			System.out.println("index" + index + ":" + res);
		}
		System.out.println();
		
		//reverse
//		reverse(singleLinkedList.getHead());
//		singleLinkedList.show();
//		System.out.println();
		
		//reversePrint
		System.out.println("reverse:");
		reversePrint(singleLinkedList.getHead());
		System.out.println();
		
		//merge
		SingleLinkedList singleLinkedList2 = new SingleLinkedList();
		singleLinkedList2.add(new Node(5, "hu10"));
		singleLinkedList2.add(new Node(7, "li4"));
		singleLinkedList2.add(new Node(18, "wang5"));
		singleLinkedList2.show();
		System.out.println();
		
		SingleLinkedList merge = new SingleLinkedList(merge(singleLinkedList.getHead(), singleLinkedList2.getHead()));
		merge.show();
	}

	//����������Ч�ڵ�ĸ���
	public static int getLength(Node head) {
		Node temp = head.next;
		int length = 0;
		
		while (temp != null) {
			length++;
			temp = temp.next;
		}
		
		return length;
	}
	
	//���ҵ������еĵ�����k���ڵ�
	public static Node getLastIndexNode(Node head, int index) {
		Node temp = head;
		Node cur = head;
		int count = 0;
		

		//����1���Ȼ�ó��� ��length-index
//		int length = getLength(head);
//		
//		if (index > length || index <= 0) {
//			return null;
//		}
//		for (int i = 0; i <= length - index; i++) {
//			temp = temp.next;
//		}
//		return temp;
		
		//����2��˫ָ��
		while (temp.next != null) {
			temp = temp.next;
			count++;
			
			if (count >= index) {
				cur = cur.next;
			}
		}
		return cur;
	}

	//������ת
	public static void reverse(Node head) {
		//��ԭ����û�нڵ����ֻ��һ���ڵ㣬�����跴ת
		Node temp = head.next;
		
		Node newHead = new Node(0, "");
		
		//ͷ�巨����
		while (temp != null) {
			Node next = temp.next;
			temp.next = newHead.next;
			newHead.next = temp;
			
			temp = next;
		}
		//����������ԭ������
		head.next = newHead.next;
	}

	//�����ӡ ���ı�ԭ˳��
	public static void reversePrint(Node head) {
		//stackʵ��
		Node temp = head.next;
		Stack<Node> stack = new Stack<>();
		
		//��ջ
		while (temp != null) {
			stack.add(temp);
			temp = temp.next;
		}
		
		//��ջ��ӡ
		while (stack.size() > 0) {
			System.out.println(stack.pop());
		}
	
	}
	
	//�ϲ��������������ϲ�֮����Ȼ����
	public static Node merge(Node head1, Node head2) {
		Node newHead = new Node(0, "");
		
		Node t1 = head1.next;
		Node t2 = head2.next;
		Node t = newHead;
		
		//β�巨
		while (t1 != null || t2 != null) {
			if (t2 == null || (t1 != null && t2 != null && t1.no < t2.no)) {
				Node next = t1.next;
				t.next = t1;
				t.next.next = null;
				
				t = t.next;
				t1 = next;
			}
			else if (t1 == null || (t1 != null && t2 != null && t1.no > t2.no)) {
				Node next = t2.next;
				t.next = t2;
				t.next.next = null;
				
				t = t.next;
				t2 = next;
			}
		}
		
		return newHead;
	}

}
