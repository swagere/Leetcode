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
		
		//1. ��ԭ�ַ���תΪbyte[]���飨ASCII�룩
		byte[] bytes = str.getBytes();
		
		byte[] huffmanBytes = HuffmanZip(bytes);
		
		for (int i = 0; i < huffmanBytes.length; i++) {
			System.out.print(huffmanBytes[i] + " ");
		}
	}
	
	public static byte[] HuffmanZip(byte[] bytes) {
		//���bytes�����Ӧ��nodes�ڵ㼯��
		List<Node> nodes = getNodes(bytes);
		
		//4. ������������
		Node huffmanTreeRoot = getHuffmanTree(nodes);
//		huffmanTreeRoot.preOrder();
		
		//5. ��ÿ��Ҷ�ӽڵ���루�����ƣ� map
		Map<Byte, String> huffmanCodes = getCodes(huffmanTreeRoot);
		
		//6. ���ݱ����map���� ��ԭbytes������б���
		//1010100010111111110010001011111111001000101111111100100101001101110001110000011011101000111100101000101111111100110001001010011011100
		String huffmanCodeString = getCodeString(bytes, huffmanCodes);
		
		//7. ѹ����ò����Ӧ��ԭ��ת����ʮ��������
		byte[] huffmanCodeBytes = zip(huffmanCodeString);
		
		return huffmanCodeBytes;
	}


	private static List<Node> getNodes(byte[] bytes) {
		//2. ���ԭ�ַ�����Ӧ��Map����ÿ���ַ����ֵĴ�����
		Map<Byte, Integer> map = new HashMap<>();
		for (int i = 0; i < bytes.length; i++) {
			map.put(bytes[i], map.getOrDefault(bytes[i], 0) + 1);
		}
		
		//3. ���map��Ӧ�Ľڵ㼯��list
		List<Node> nodes = new ArrayList<>();
		for (Entry<Byte, Integer> b : map.entrySet()) {
			nodes.add(new Node(b.getKey(), b.getValue()));
		}
		
		return nodes;
	}
	
	//������������
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
	
	//ǰ����� ���������
	public static void preOrder(Node root) {
		if (root != null) {
			root.preOrder();
		}
		else {
			System.out.println("null! Can not print");
		}
	}
	
	//���ݹ������� ��ö����ƹ���������
	static Map<Byte, String> HuffmanCodes = new HashMap<>();
	//����
	public static Map<Byte, String> getCodes(Node root) {
		StringBuilder stringBuilder = new StringBuilder("");
		if (root != null) {
			//����������
			getCodes(root.left, 0, stringBuilder);
			
			//����������
			getCodes(root.right, 1, stringBuilder);
		}
		return HuffmanCodes;
	}
	
	//node ��ǰ�ڵ�
	//��ǰ·��Ȩֵ
	//·��Ȩֵ��
	public static void getCodes(Node node, int code, StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		
		stringBuilder2.append(code);
		
		if (node != null) {
			if (node.data == null) { //˵������Ҷ�ӽڵ�
				//����ݹ�
				getCodes(node.left, 0, stringBuilder2);
				
				//���ҵݹ�
				getCodes(node.right, 1, stringBuilder2);
			}
			else {
				HuffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
	
	//���ݱ���õ�map �����Ϣ��Ӧ����byte����
	private static String getCodeString(byte[] bytes, Map<Byte, String> huffmanCodes) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			s.append(huffmanCodes.get(bytes[i]));
		}
		return s.toString();
	}
	
	//ѹ�� 
	//����תԭ��
	private static byte[] zip(String huffmanCodeString) {
		int len = (huffmanCodeString.length() + 7) / 8;
		
		byte[] bytes = new byte[len];
		int index = 0;
		
		for (int i = 0; i < huffmanCodeString.length(); i += 8) {
			String str = "";
			if (i + 8 > huffmanCodeString.length()) {
				str = huffmanCodeString.substring(i); //Ĭ���Ǵ�i�����
			}
			else {
				str = huffmanCodeString.substring(i, i + 8); //i��i+7 ����ҿ�����
			}
			bytes[index] = (byte)Integer.parseInt(str, 2);
			index += 1;
		}
		return bytes;
	}
}
