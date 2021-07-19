package com.kve.tree;

//˳��洢������:��������洢������
public class ArrayBinaryTree {
	int[] array = null;
	
	//���췽��
	public ArrayBinaryTree(int[] array) {
		this.array = array;
	}
	
	//���ظ÷���
	public void preOrder() {
		preOrder(0);
	}
	
	//ǰ�����
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
	
	//���ظ÷���
	public void infixOrder() {
		infixOrder(0);
	}
	
	//�������
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
	
	//���ظ÷���
	public void postOrder() {
		postOrder(0);
	}
	
	//�������
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