package com.kve.avltree;

public class AVLTree {
	private static Node root;

	public static void main(String[] args) {
//		int[] nums = {4,3,6,5,7,8};
//		int[] nums = {10,8,12,7,9,6};
//		int[] nums = {10,11,7,6,8,9};
		int[] nums = {4,3,2,5,6,7,1,8};
		
		for (int i : nums) {
			add(i);
			Node temp = root;
			System.out.println(root);
		}
		
		infixOrder();
		System.out.println();
		
		System.out.println("tree:");
		System.out.println(root);
		System.out.println(root.left);
		System.out.println(root.right);
		System.out.println(root.left.left);
		System.out.println(root.left.right);
		System.out.println(root.right.left);
		System.out.println(root.right.right);
		System.out.println(root.left.left.left);
		

	}
	
	//中序遍历
	public static void infixOrder() {
		if (root == null) {
			System.out.println("null");
		}
		else {
			root.infixOrder();
		}
	}
	
	//新增/创建节点
	public static void add(int val) {
		if (root == null) {
			root = new Node(val);
		}
		else {
			root.add(val);
		}
	}

}
