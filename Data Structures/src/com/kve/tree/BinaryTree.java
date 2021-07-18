package com.kve.tree;

public class BinaryTree {
	private MyTreeNode root;

	public MyTreeNode getRoot() {
		return root;
	}

	public void setRoot(MyTreeNode root) {
		this.root = root;
	}
	
	//前序遍历
	public void preOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.preOrder();
	}
	
	//中序遍历
	public void infixOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.infixOrder();
	}
	
	//后序遍历
	public void postOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.postOrder();
	}
	
	//前序遍历查找
	public MyTreeNode preOrderSearch(int id) {
		if (this.root != null) {
			return this.root.preOrderSearch(id);
		}
		
		return null;
	}
	
	//中序遍历查找
	public MyTreeNode infixOrderSearch(int id) {
		if (this.root != null) {
			return this.root.infixOrderSearch(id);
		}
		
		return null;
	}
	
	//后序遍历查找
	public MyTreeNode postOrderSearch(int id) {
		if (this.root != null) {
			return this.root.postOrderSearch(id);
		}
		
		return null;
	}
}