package com.kve.linkedlist;

//链表类
public class SingleLinkedList {
	private Node head = new Node(0, ""); //头节点 不可改变
	
	public SingleLinkedList(Node head) {
		this.head = head;
	}
	
	public SingleLinkedList() {}

	//尾插法添加
	public void add(Node node) {
		Node temp = head; //辅助节点 辅助进行遍历
		
		//循环找到尾节点
		while (true) {
			if (temp.next == null) {
				//找到尾节点
				break;
			}
			
			//没有找到尾节点
			temp = temp.next;
		}
		
		//插入
		temp.next = node;
	}
	
	//按顺序添加
	public void addByOrder(Node node) {
		//注意查找到添加的前一个
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
			System.out.println("要插入的元素已重复");
		}
		else {
			node.next = temp.next;
			temp.next = node;
		}
	}
	
	//修改一个节点
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
			//更新
			temp.name = node.name;
		}
		else {
			System.out.println("该节点不存在 无法修改");
		}
	}
	
	//删除一个节点
	public void remove(int index) {
		//先找到要删除节点的前一个节点
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
			//删除节点
			temp.next = temp.next.next;
		}
		else {
			System.out.println("该节点不存在 删除失败");
		}
	}
	
	//链表显示
	public void show() {
		Node temp = head.next; //辅助节点 辅助进行遍历
		
		//循环找到尾节点
		while (true) {
			if (temp == null) {
				//找到尾节点
				break;
			}
			
			//没有找到尾节点 就打印该节点
			System.out.println(temp);
			temp = temp.next;
		}
		
	}

	//获得头节点
	public Node getHead() {
		return head;
	}
}

//链表节点
//data node
class Node {
	Integer no;
	String name;
	Node next;
	
	
	//构造方法
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
