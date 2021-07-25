package com.kve.avltree;

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
		
		//������ת����
		if (this.getRightHeight() - this.getLeftHeight() > 1) {
			if (this.right.getLeftHeight() > this.right.getRightHeight()) {
				this.right.rightRotate();
			}
			//����ת
			leftRotate();
		}
		else if (this.getLeftHeight() - this.getRightHeight() > 1) {
			if (this.left.getRightHeight() > this.left.getLeftHeight()) {
				this.left.leftRotate();
			}
			//����ת
			rightRotate();
		}
	}

	//��ȡ�����߶�
	public int getHeight() {
		return Math.max(this.left == null ? 0 : this.left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
	}
	
	//��ȡ�������߶�
	public int getRightHeight() {
		if (this.right == null) {
			return 0;
		}
		return this.right.getHeight();
	}
	
	//��ȡ�������߶�
	private int getLeftHeight() {
		if (this.left == null) {
			return 0;
		}
		return this.left.getHeight();
	}
	
	//����ת
	public void leftRotate() {
		Node newNode = new Node(this.value); //����ڵ��ܴ˷�����˵����Ϊ��
		
		newNode.left = this.left;
		
		newNode.right = this.right.left;
		
		this.value = this.right.value;
		
		this.right = this.right.right;
		
		this.left = newNode;
	}
	
	//����ת
	public void rightRotate() {
		Node newNode = new Node(this.value); //�ȸ����Լ�
		
		newNode.right = this.right;
		
		newNode.left = this.left.right;
		
		this.value = this.left.value;
		
		this.right = newNode;
		
		this.left = this.left.left;
	}
}
