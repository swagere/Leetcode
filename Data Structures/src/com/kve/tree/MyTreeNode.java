package com.kve.tree;

public class MyTreeNode {
	private int id;
	private String name;
	private MyTreeNode left = null;
	private MyTreeNode right = null;
	
	public MyTreeNode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyTreeNode getLeft() {
		return left;
	}

	public void setLeft(MyTreeNode left) {
		this.left = left;
	}

	public MyTreeNode getRight() {
		return right;
	}

	public void setRight(MyTreeNode right) {
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "[ id:" + id + " name:" + name + " ]";
	}
	
	//前序遍历 根左右
	public void preOrder() {
		System.out.println(this);
		
		if (this.left != null) {
			this.left.preOrder();
		}
		
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	//中序遍历 左根右
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	
	//后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		
		
		if (this.right != null) {
			this.right.postOrder();
		}
		
		System.out.println(this);
	}
}
