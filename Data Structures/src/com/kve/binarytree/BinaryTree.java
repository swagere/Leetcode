package com.kve.binarytree;

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
	
	//ɾ��
	//���ж����Ƿ�Ϊ��
	//���жϸ��ڵ�
	public void delNode1(int id) {
		if (this.root != null) {
			if (root.getId() == id) {
				root = null;
			}
			else {
				this.root.delNode1(id);
			}
		}
		else {
			System.out.println("����Ϊ�� �޷�ɾ���ڵ�");
		}
	}
	
	public void delNode2(int id) {
		if (this.root != null) {
			if (root.getId() == id) {
				this.root = null;
			}
			else {
				MyTreeNode res = this.root.delNode2(id);
				if (res == null) {
					System.out.println("û���ҵ��ýڵ� ɾ��ʧ��");
				}
				else {
					res.preOrder();
				}
			}
		}
		else {
			System.out.println("����Ϊ�� �޷�ɾ���ڵ�");
		}
	}
	
	public void delNode3(int id) {
		if (this.root != null) {
			if (root.getId() == id) {
				//�ж��Ƿ��������ӽڵ�
				if (this.root.getLeft() != null && this.root.getRight() != null) {
					//���������ӽڵ� �������ӽڵ������ǰ�ڵ�
					this.root = this.root.getLeft();
				}
				else if (this.root.getLeft() != null) {
					this.root = this.root.getLeft();
				}
				else if (this.root.getRight() != null) {
					this.root = this.root.getRight();
				}
			}
			else {
				MyTreeNode res = this.root.delNode3(id);
				if (res == null) {
					System.out.println("û���ҵ��ýڵ� ɾ��ʧ��");
				}
				else {
					System.out.println(res);
				}
			}
		}
		else {
			System.out.println("����Ϊ�� �޷�ɾ���ڵ�");
		}
	}
}