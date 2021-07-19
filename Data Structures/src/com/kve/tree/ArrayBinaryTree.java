package com.kve.tree;

//顺序存储二叉树:即用数组存储二叉树
public class ArrayBinaryTree {
	int[] array = null;
	
	//构造方法
	public ArrayBinaryTree(int[] array) {
		this.array = array;
	}
	
	//重载该方法
	public void preOrder() {
		preOrder(0);
	}
	
	//前序遍历
	public void preOrder(int index) {
		if (array == null || array.length == 0) {
			System.out.println("null");
			return;
		}
		if (index < this.array.length) {
			System.out.print(array[index]);
		}
		
		if (2 * index + 1 < this.array.length) {
			preOrder(2 * index + 1);
		}
		
		if (2 * index + 2 < this.array.length) {
			preOrder(2 * index + 2);
		}
	}
	
	//重载该方法
	public void infixOrder() {
		infixOrder(0);
	}
	
	//中序遍历
	public void infixOrder(int index) {
		if (array == null || array.length == 0) {
			System.out.println("null");
			return;
		}
		
		if (2 * index + 1 < this.array.length) {
			infixOrder(2 * index + 1);
		}
		
		if (index < this.array.length) {
			System.out.print(array[index]);
		}
		
		if (2 * index + 2 < this.array.length) {
			infixOrder(2 * index + 2);
		}
	}
	
	//重载该方法
	public void postOrder() {
		postOrder(0);
	}
	
	//后序遍历
	public void postOrder(int index) {
		if (array == null || array.length == 0) {
			System.out.println("null");
			return;
		}
		
		if (2 * index + 1 < this.array.length) {
			postOrder(2 * index + 1);
		}
		
		if (2 * index + 2 < this.array.length) {
			postOrder(2 * index + 2);
		}
		
		if (index < this.array.length) {
			System.out.print(array[index]);
		}
	}
}