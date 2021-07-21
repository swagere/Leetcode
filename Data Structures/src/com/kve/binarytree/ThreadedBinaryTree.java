package com.kve.binarytree;

public class ThreadedBinaryTree{
	private MyTreeNode root;
	private MyTreeNode pre = null; //������ָ�� һ����ǰ һ���ں�
	
	public MyTreeNode getRoot() {
		return root;
	}

	public void setRoot(MyTreeNode root) {
		this.root = root;
	}

	//����
	//�������
	public void threadedInfixBinaryTree() {
		threadedInfixBinaryTree(root);
	}
	
	//������������
	//����ֵ��������
	//����
	public void threadedInfixBinaryTree(MyTreeNode node) {
		if (node.getLeft() != null) {
			threadedInfixBinaryTree(node.getLeft());
		}
		
		//��������������ֵ
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) { //�ж�pre�Ƿ�Ϊ0
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
		
		if (node.getRight() != null) {
			threadedInfixBinaryTree(node.getRight());
		}
	}
	
	//�����������������
	//����
	public void infixOrder() {
		MyTreeNode node = root;
		
		while (node != null) {
			//�������ҵ���һ��ǰ���ڵ�
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			
			//������Ѱ�Һ�̽ڵ�
			System.out.println(node);
			
			while (node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	
	
	
	
	//����
	//ǰ�����
	public void threadedPreBinaryTree() {
		threadedPreBinaryTree(root);
	}
	
	//������������
	//����ֵ��������
	//ǰ��
	public void threadedPreBinaryTree(MyTreeNode node) {
		//��������������ֵ
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) { //�ж�pre�Ƿ�Ϊ0
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
				
		if (node.getLeftType() == 0 && node.getLeft() != null) {
			threadedPreBinaryTree(node.getLeft());
		}
		
		if (node.getRightType() == 0 && node.getRight() != null) {
			threadedPreBinaryTree(node.getRight());
		}
	}
	
	//�����������������
	//ǰ��
	public void preOrder() {
		MyTreeNode node = root;
		
		while (node != null) {
			//��������ڵ�
			System.out.println(node);
			
			//�������ҵ���һ��ǰ���ڵ�
			while (node.getLeftType() == 0) {
				node = node.getLeft();
				System.out.println(node);
			}
			
			
			while (node.getRightType() == 1) {
				node = node.getRight();
			}
			node = node.getRight();
		}
	}
	
	
	
	//����
	//�������
	public void threadedPostBinaryTree() {
		threadedPostBinaryTree(root);
	}
	
	//������������
	//����ֵ��������
	//����
	public void threadedPostBinaryTree(MyTreeNode node) {
		if (node.getLeftType() == 0 && node.getLeft() != null) {
			threadedPostBinaryTree(node.getLeft());
		}
		
		if (node.getRightType() == 0 && node.getRight() != null) {
			threadedPostBinaryTree(node.getRight());
		}
		
		//��������������ֵ
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) { //�ж�pre�Ƿ�Ϊ0
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
	}
	
	//�����������������
	//����
	public void postOrder() {
		postOrder(root);
	}
	public void postOrder(MyTreeNode node) {
		if (node.getLeft() != null && node.getLeftType() == 0) {
			postOrder(node.getLeft());
		}
		
		if (node.getRight() != null && node.getRightType() == 0) {
			postOrder(node.getRight());
		}
		
		System.out.println(node);
	}
}
