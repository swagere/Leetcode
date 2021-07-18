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
	
	//ǰ����� ������
	public void preOrder() {
		System.out.println(this);
		
		if (this.left != null) {
			this.left.preOrder();
		}
		
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	//������� �����
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	
	//�������
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		
		
		if (this.right != null) {
			this.right.postOrder();
		}
		
		System.out.println(this);
	}

	
	//ǰ��������� ������
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
	
	//����������� �����
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
	
	//����������� ���Ҹ�
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
		
		System.out.println(3); //����Ƚϴ��� Ӧ�÷��ڱȽ�֮ǰ��׼ȷ ������ǰ�����ֻ���ж����Ƿ�Ϊ�ն�û�бȽ�
		if (this.id == id) {
			return this;
		}
		return res;
	}
}
