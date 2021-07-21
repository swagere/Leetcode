package com.kve.binarytree;

public class ArrayBinaryTreeDemo {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(array);
		arrayBinaryTree.postOrder();

	}

}
