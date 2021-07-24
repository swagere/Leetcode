package com.kve.binarysorttree;

public class BinarySortTree {
	private static Node root;

	public static void main(String[] args) {
		int[] nums = {7,3,10,12,5,1,9,0};
//		int[] nums = {1};
		
		//创建二叉排序树
		for (int i : nums) {
			add(i);
		}
		
		//中序遍历打印
		infixOrder();
		System.out.println();
		
		delNode(7);

		//中序遍历打印
		infixOrder();
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
	
	//删除节点
	public static void delNode(int val) {
		//--1. 找到待删除节点与其父节点----------------------------------------
		//先判断根节点是否为空
		if (root == null) {
			System.out.println("null! Can not delete!");
			return;
		}
		//找到当前节点的父节点
		Node parent = getParent(val);
		Node target = null;
		int dir = -1;
		
		//判断父节点是否为空
		if (parent == null) {
			//如果根节点不等于val 则说明没有找到
			if (root.value != val) {
				System.out.println("没有找到该节点");
				return;
			}
			else {
				//根节点为目标节点
				target = root;
			}
		}
		else {
			//如果存在父节点 则说明一定找到
			//存储target节点
			if (parent.left != null && parent.left.value == val) {
				target = parent.left;
				dir = 0; //target为左子节点
			}
			else if (parent.right != null && parent.right.value == val){
				target = parent.right;
				dir = 1; //target为右子节点
			}
			else {
				System.out.println("没有找到该节点");
				return;
			}
		}
		
//		System.out.println("parent:" + parent);
//		System.out.println("target:" + target);
//		if(dir == 0) System.out.println("左"); else if(dir == 1) System.out.println("右"); else System.out.println("no root");
		
		//--2. 判断三种情况 叶子节点 一个子节点 两个子节点--------------------------------------------
		if (target.left == null && target.right == null) {
			//如果是叶子节点
			if (dir == -1) {
				//如果是根节点 则整棵树说明只有根节点
				root = null;
			}
			else if (dir == 0){
				//如果在左边
				parent.left = null;
			}
			else {
				parent.right = null;
			}
		}
		else if (target.left != null && target.right != null) {
			//如果有两个叶子节点
			//找到左子树中最大的替换
			Node temp = target.left;
			while (temp.right != null) {
				temp = temp.right;
			}
			delNode(temp.value);
			
			if (dir == -1) {
				//如果是根节点 则整棵树说明只有根节点
				root.value = temp.value;
			}
			else if (dir == 0){
				//如果在左边
				parent.left.value = temp.value;
			}
			else {
				parent.right.value = temp.value;
			}
			
		}
		else {
			//如果有一个叶子节点
			if (target.left != null) {
				if (dir == -1) {
					//如果是根节点 则整棵树说明只有根节点
					root = target.left;
				}
				else if (dir == 0){
					//如果在左边
					parent.left = target.left;
				}
				else {
					parent.right = target.left;
				}
			}
			else {
				if (dir == -1) {
					//如果是根节点 则整棵树说明只有根节点
					root = target.right;
				}
				else if (dir == 0){
					//如果在左边
					parent.left = target.right;
				}
				else {
					parent.right = target.right;
				}
			}
		}
	}
	
	//查找要删除节点的父节点
	public static Node getParent(int val) {
		if (root == null) {
			return null;
		}
		else {
			return root.getParent(val);
		}
	}
}
