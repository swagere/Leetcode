package com.kve.binarysorttree;

public class Node {
	int value;
	Node left;
	Node right;
	
	public Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	//�������
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	//����/����
	public void add(int val) {
		if (val < this.value) {
			if (this.left == null) {
				this.left = new Node(val);
			}
			else {
				this.left.add(val);
			}
		}
		else {
			if (this.right == null) {
				this.right = new Node(val);
			}
			else {
				this.right.add(val);
			}
		}
	}
	
	//�ҵ���ɾ���ڵ�ĸ��ڵ�
	public Node getParent(int val) {
		if (this.value > val) {
			if (this.left != null) {
				if (this.left.value == val) {
					return this;
				}
				else {
					return this.left.getParent(val);
				}
			}
			return null;
		}
		else {
			//������
			if (this.right != null) {
				if (this.right.value == val) {
					return this;
				}
				else {
					return this.right.getParent(val);
				}
			}
			return null;
		}
	}
}
