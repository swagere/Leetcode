package com.kve.huffmantree.huffmanCode;

public class Node implements Comparable<Node>{
	Byte data; //字符内容 将一个字符传换成一个byte(Ascii)
	int weight;
	Node left = null;
	Node right = null;
	
	@Override
	public String toString() {
		return "Node [data=" + data + ", weight=" + weight + "]";
	}

	public Node(Byte data, int weight) {
		super();
		this.data = data;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		//从小到大排序
		return this.weight - o.weight;
	}
	
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
