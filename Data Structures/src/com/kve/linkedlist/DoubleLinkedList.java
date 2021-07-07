package com.kve.linkedlist;

public class DoubleLinkedList {
	private DNode head = new DNode(0, ""); //头节点 不可改变
	
	//构造方法
	public DoubleLinkedList(DNode head) {
		this.head = head;
	}
	
	public DoubleLinkedList() {}
	
	//尾插法添加
	public void add(DNode node) {
		DNode temp = head; //辅助节点 辅助进行遍历
		
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
		node.pre = temp;
	}
	
	//链表显示
	public void show() {
		DNode temp = head.next; //辅助节点 辅助进行遍历
		
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
	
	//按顺序添加
	public void addByOrder(DNode node) {
		//直接查找到需要添加的那一个
		DNode temp = head;
		boolean flag = false; //标记是否重复
		
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
			System.out.println("要插入的元素已重复");
		}
		else {
			node.next = temp;
			node.pre = temp.pre;
			temp.pre.next = node;
			temp.pre = node;
		}
	}
	
	//修改一个节点
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
			//删除节点
			
			temp.pre.next = temp.next;
			
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}
			
		}
		else {
			System.out.println("该节点不存在 删除失败");
		}
	}


	
}

//链表节点
//data node
class DNode {
	Integer no;
	String name;
	DNode next;
	DNode pre;
	
	
	//构造方法
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