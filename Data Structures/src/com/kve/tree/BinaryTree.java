package com.kve.tree;

public class BinaryTree {
	private MyTreeNode root;

	public MyTreeNode getRoot() {
		return root;
	}

	public void setRoot(MyTreeNode root) {
		this.root = root;
	}
	
	//ǰ�����
	public void preOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.preOrder();
	}
	
	//�������
	public void infixOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.infixOrder();
	}
	
	//�������
	public void postOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.postOrder();
	}
	
	//ǰ���������
	public MyTreeNode preOrderSearch(int id) {
		if (this.root != null) {
			return this.root.preOrderSearch(id);
		}
		
		return null;
	}
	
	//�����������
	public MyTreeNode infixOrderSearch(int id) {
		if (this.root != null) {
			return this.root.infixOrderSearch(id);
		}
		
		return null;
	}
	
	//�����������
	public MyTreeNode postOrderSearch(int id) {
		if (this.root != null) {
			return this.root.postOrderSearch(id);
		}
		
		return null;
	}
}