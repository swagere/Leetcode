package com.kve.binarytree;

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
		
		binaryTree.preOrder();
		System.out.println();
		
//		binaryTree.infixOrder();
		
//		binaryTree.postOrder();
		
//		System.out.println(binaryTree.preOrderSearch(15));
		
//		System.out.println(binaryTree.infixOrderSearch(5));
		
//		System.out.println(binaryTree.postOrderSearch(5));
		
//		binaryTree.delNode1(5);
		
//		binaryTree.delNode2(3);
		
		binaryTree.delNode3(2);
		
		System.out.println();
		binaryTree.preOrder();
	}

}
