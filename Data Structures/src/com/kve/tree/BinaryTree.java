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
	
	//后序
	public void postOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.postOrder();
	}
}