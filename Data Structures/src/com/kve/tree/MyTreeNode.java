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

	
	//前序遍历查找 根左右
	public MyTreeNode preOrderSearch(int id) {
		System.out.println(1);
		if (this.id == id) {
			return this;
		}
		
		MyTreeNode res = null;
		if (this.left != null) { 
			res = this.left.preOrderSearch(id);
		}
		if (res != null) {
			return res;
		}
		
		if (this.right != null) {
			res = this.right.preOrderSearch(id);
		}
		return res;
	}
	
	//中序遍历查找 左根右
	public MyTreeNode infixOrderSearch(int id) {
		
		MyTreeNode res = null;
		if (this.left != null) { 
			res = this.left.infixOrderSearch(id);
		}
		if (res != null) {
			return res;
		}
		
		System.out.println(2);
		if (this.id == id) {
			return this;
		}
		
		if (this.right != null) {
			res = this.right.infixOrderSearch(id);
		}
		return res;
	}
	
	//后序遍历查找 左右根
	public MyTreeNode postOrderSearch(int id) {
		
		MyTreeNode res = null;
		if (this.left != null) { 
			res = this.left.postOrderSearch(id);
		}
		if (res != null) {
			return res;
		}	
		
		
		if (this.right != null) {
			res = this.right.postOrderSearch(id);
		}
		if (res != null) {
			return res;
		}
		
		System.out.println(3); //计算比较次数 应该放在比较之前才准确 放在最前面可能只是判断了是否为空而没有比较
		if (this.id == id) {
			return this;
		}
		return res;
	}
}
