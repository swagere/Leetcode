package com.kve.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	private static Node root;

	public static void main(String[] args) {
		int[] nums = {13,7,8,3,29,6,1};
		
		createHuffmanTree(nums);
		
		preOrder();
	}
	
	//构建huffman树
	public static void createHuffmanTree(int[] nums) {
		//将数组中每个元素构造成树
		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			Node node = new Node(nums[i]);
			nodes.add(node);
		}
		
		while (nodes.size() > 1) {
			Collections.sort(nodes);
			
			Node left = nodes.remove(0);
			Node right = nodes.remove(0);
			
			Node nowNode = new Node(left.value + right.value);
			nowNode.left = left;
			nowNode.right = right;
			
			nodes.add(nowNode);
		}
		
		root = nodes.get(0);
	}
	
	//前序遍历输出
	public static void preOrder() {
		if (root != null) {
			root.preOrder();
		}
	}

}
