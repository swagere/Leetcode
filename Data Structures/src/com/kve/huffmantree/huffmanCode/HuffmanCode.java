package com.kve.huffmantree.huffmanCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanCode {
	public static void main(String[] args) {
		String str = "I like like like java do you like a java";
		
		//1. 将原字符串转为byte[]数组（ASCII码）
		byte[] bytes = str.getBytes();
		
		byte[] huffmanBytes = HuffmanZip(bytes);
		
		for (int i = 0; i < huffmanBytes.length; i++) {
			System.out.print(huffmanBytes[i] + " ");
		}
	}
	
	public static byte[] HuffmanZip(byte[] bytes) {
		//获得bytes数组对应的nodes节点集合
		List<Node> nodes = getNodes(bytes);
		
		//4. 构建哈夫曼树
		Node huffmanTreeRoot = getHuffmanTree(nodes);
//		huffmanTreeRoot.preOrder();
		
		//5. 给每个叶子节点编码（二进制） map
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		
		//6. 根据编码的map集合 对原bytes数组进行编码
		//1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		String huffmanCodeString = getCodeString(bytes, huffmanCodes);
		
		//7. 压缩获得补码对应的原码转换的十进制数组
		byte[] huffmanCodeBytes = zip(huffmanCodeString);
		
		return huffmanCodeBytes;
	}


	private static List<Node> getNodes(byte[] bytes) {
		//2. 获得原字符串对应的Map（即每个字符出现的次数）
		Map<Byte, Integer> map = new HashMap<>();
		for (int i = 0; i < bytes.length; i++) {
			map.put(bytes[i], map.getOrDefault(bytes[i], 0) + 1);
		}
		
		//3. 获得map对应的节点集合list
		List<Node> nodes = new ArrayList<>();
		for (Entry<Byte, Integer> b : map.entrySet()) {
			nodes.add(new Node(b.getKey(), b.getValue()));
		}
		
		return nodes;
	}
	
	//构建哈夫曼树
	private static Node getHuffmanTree(List<Node> nodes) {

		while (nodes.size() > 1) {
			Collections.sort(nodes);
			Node left = nodes.remove(0);
			Node right = nodes.remove(0);
			
			Node newNode = new Node(null, left.weight + right.weight);
			newNode.left = left;
			newNode.right = right;
			nodes.add(newNode);
		}
		
		return nodes.get(0);
	}
	
	//前序遍历 输出二叉树
	public static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		}
		else {
			System.out.println("null! Can not print");
		}
	}
	
	//根据哈夫曼树 获得二进制哈夫曼编码
	static Map<Byte, String> HuffmanCodes = new HashMap<>();
	//重载
	public static Map<Byte, String> getCodes(Node root) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (root != null) {
			//处理左子树
			getCodes(root.left, 0, stringBuilder);
			
			//处理右子树
			getCodes(root.right, 1, stringBuilder);
		}
		return HuffmanCodes;
	}
	
	//node 当前节点
	//当前路径权值
	//路径权值集
	public static void getCodes(Node node, int code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		
		stringBuilder2.append(code);
		
		if (node != null) {
			if (node.data == null) { //说明不是叶子节点
				//向左递归
				getCodes(node.left, 0, stringBuilder2);
				
				//向右递归
				getCodes(node.right, 1, stringBuilder2);
			}
			else {
				HuffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
	
	//根据编码好的map 获得消息对应编码byte数组
	private static String getCodeString(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			s.append(huffmanCodes.get(bytes[i]));
		}
		return s.toString();
	}
	
	//压缩 
	//补码转原码
	private static byte[] zip(String huffmanCodeString) {
		int len = (huffmanCodeString.length() + 7) / 8;
		
		byte[] bytes = new byte[len];
		int index = 0;
		
		for (int i = 0; i < huffmanCodeString.length(); i += 8) {
			String str = "";
			if (i + 8 > huffmanCodeString.length()) {
				str = huffmanCodeString.substring(i); //默认是从i到最后
			}
			else {
				str = huffmanCodeString.substring(i, i + 8); //i到i+7 左闭右开区间
			}
			bytes[index] = (byte)Integer.parseInt(str, 2);
			index += 1;
		}
		return bytes;
	}
}
