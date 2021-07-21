package com.kve.binarytree;

public class ThreadedBinaryTreeDemo {

	public static void main(String[] args) {
		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
		MyTreeNode node1 = new MyTreeNode(1, "zhang3");
		MyTreeNode node2 = new MyTreeNode(2, "zhang3");
		MyTreeNode node3 = new MyTreeNode(3, "zhang3");
		MyTreeNode node4 = new MyTreeNode(4, "zhang3");
		MyTreeNode node5 = new MyTreeNode(5, "zhang3");
		threadedBinaryTree.setRoot(node1);
		node1.setLeft(node2);
		node1.setRight(node3);
		node3.setLeft(node5);
		node3.setRight(node4);
		
//		ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
//		MyTreeNode node1 = new MyTreeNode(1, "zhang3");
//		MyTreeNode node3 = new MyTreeNode(3, "zhang3");
//		MyTreeNode node6 = new MyTreeNode(6, "zhang3");
//		MyTreeNode node8 = new MyTreeNode(8, "zhang3");
//		MyTreeNode node10 = new MyTreeNode(10, "zhang3");
//		MyTreeNode node14 = new MyTreeNode(14, "zhang3");
//		threadedBinaryTree.setRoot(node1);
//		node1.setLeft(node3);
//		node1.setRight(node6);
//		node3.setLeft(node8);
//		node3.setRight(node10);
//		node6.setLeft(node14);

		threadedBinaryTree.threadedPostBinaryTree();
		
//		System.out.println(node2.getLeft());
//		System.out.println(node2.getRight());
		
		threadedBinaryTree.postOrder();
	}

}
