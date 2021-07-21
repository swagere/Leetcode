package com.kve.huffmantree;

public class Node implements Comparable<Node>{
	int value;
	Node left = null;
	Node right = null;
	
	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	
	//������
	public Node(int value) {
		this.value = value;
	}

	//���ӱȽ��� ����list��ndoe����
	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
	
	//ǰ��������
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
