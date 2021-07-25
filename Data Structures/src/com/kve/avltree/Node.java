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
	
	//中序遍历
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	//新增/创建
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
		
		//考虑旋转问题
		if (this.getRightHeight() - this.getLeftHeight() > 1) {
			if (this.right.getLeftHeight() > this.right.getRightHeight()) {
				this.right.rightRotate();
			}
			//左旋转
			leftRotate();
		}
		else if (this.getLeftHeight() - this.getRightHeight() > 1) {
			if (this.left.getRightHeight() > this.left.getLeftHeight()) {
				this.left.leftRotate();
			}
			//右旋转
			rightRotate();
		}
	}

	//获取子树高度
	public int getHeight() {
		return Math.max(this.left == null ? 0 : this.left.getHeight(), this.right == null ? 0 : this.right.getHeight()) + 1;
	}
	
	//获取右子树高度
	public int getRightHeight() {
		if (this.right == null) {
			return 0;
		}
		return this.right.getHeight();
	}
	
	//获取左子树高度
	private int getLeftHeight() {
		if (this.left == null) {
			return 0;
		}
		return this.left.getHeight();
	}
	
	//左旋转
	public void leftRotate() {
		Node newNode = new Node(this.value); //这个节点能此方法则说明不为空
		
		newNode.left = this.left;
		
		newNode.right = this.right.left;
		
		this.value = this.right.value;
		
		this.right = this.right.right;
		
		this.left = newNode;
	}
	
	//右旋转
	public void rightRotate() {
		Node newNode = new Node(this.value); //先复制自己
		
		newNode.right = this.right;
		
		newNode.left = this.left.right;
		
		this.value = this.left.value;
		
		this.right = newNode;
		
		this.left = this.left.left;
	}
}
