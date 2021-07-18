package com.kve.tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		MyTreeNode node1 = new MyTreeNode(1, "zhang3");
		MyTreeNode node2 = new MyTreeNode(2, "zhang3");
		MyTreeNode node3 = new MyTreeNode(3, "zhang3");
		MyTreeNode node4 = new MyTreeNode(4, "zhang3");
		MyTreeNode node5 = new MyTreeNode(5, "zhang3");

		binaryTree.setRoot(node1);
		node1.setLeft(node2);
		node1.setRight(node3);
		node3.setLeft(node5);
		node3.setRight(node4);
		
//		binaryTree.preOrder();
		
		binaryTree.infixOrder();
		
//		binaryTree.postOrder();
	}

}
