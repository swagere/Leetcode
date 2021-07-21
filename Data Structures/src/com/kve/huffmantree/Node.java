package com.kve.huffmantree;

public class Node implements Comparable<Node>{
	int value;
	Node left = null;
	Node right = null;
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	//构造器
	public Node(int value) {
		this.value = value;
	}

	//增加比较器 用于list中ndoe排序
	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
	
	//前序遍历输出
	public void preOrder() {
		System.out.println(this);
		
		if (this.left != null) {
			this.left.preOrder();
		}
		
		if (this.right != null) {
			this.right.preOrder();
		}
	}
}
