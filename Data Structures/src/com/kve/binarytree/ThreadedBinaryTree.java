package com.kve.binarytree;

public class ThreadedBinaryTree{
	private MyTreeNode root;
	private MyTreeNode pre = null; //用两个指针 一个在前 一个在后
	
	public MyTreeNode getRoot() {
		return root;
	}

	public void setRoot(MyTreeNode root) {
		this.root = root;
	}

	//重载
	//中序遍历
	public void threadedInfixBinaryTree() {
		threadedInfixBinaryTree(root);
	}
	
	//线索化二叉树
	//将赋值与遍历结合
	//中序
	public void threadedInfixBinaryTree(MyTreeNode node) {
		if (node.getLeft() != null) {
			threadedInfixBinaryTree(node.getLeft());
		}
		
		//线索化二叉树赋值
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) { //判断pre是否为0
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
		
		if (node.getRight() != null) {
			threadedInfixBinaryTree(node.getRight());
		}
	}
	
	//线索化二叉树的输出
	//中序
	public void infixOrder() {
		MyTreeNode node = root;
		
		while (node != null) {
			//先向左找到第一个前驱节点
			while (node.getLeftType() == 0) {
				node = node.getLeft();
			}
			
			//再依次寻找后继节点
			System.out.println(node);
			
			while (node.getRightType() == 1) {
				node = node.getRight();
				System.out.println(node);
			}
			node = node.getRight();
		}
	}
	
	
	
	
	//重载
	//前序遍历
	public void threadedPreBinaryTree() {
		threadedPreBinaryTree(root);
	}
	
	//线索化二叉树
	//将赋值与遍历结合
	//前序
	public void threadedPreBinaryTree(MyTreeNode node) {
		//线索化二叉树赋值
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) { //判断pre是否为0
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
	
	//线索化二叉树的输出
	//前序
	public void preOrder() {
		MyTreeNode node = root;
		
		while (node != null) {
			//先输出根节点
			System.out.println(node);
			
			//先向左找到第一个前驱节点
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
	
	
	
	//重载
	//后序遍历
	public void threadedPostBinaryTree() {
		threadedPostBinaryTree(root);
	}
	
	//线索化二叉树
	//将赋值与遍历结合
	//后序
	public void threadedPostBinaryTree(MyTreeNode node) {
		if (node.getLeftType() == 0 && node.getLeft() != null) {
			threadedPostBinaryTree(node.getLeft());
		}
		
		if (node.getRightType() == 0 && node.getRight() != null) {
			threadedPostBinaryTree(node.getRight());
		}
		
		//线索化二叉树赋值
		if (node.getLeft() == null) {
			node.setLeft(pre);
			node.setLeftType(1);
		}
		
		if (pre != null && pre.getRight() == null) { //判断pre是否为0
			pre.setRight(node);
			pre.setRightType(1);
		}
		
		pre = node;
	}
	
	//线索化二叉树的输出
	//后序
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
