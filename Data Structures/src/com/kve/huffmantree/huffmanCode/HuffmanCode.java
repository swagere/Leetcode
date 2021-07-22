package com.kve.huffmantree.huffmanCode;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanCode {
	public static void main(String[] args) {
		//--ѹ���ַ���--
//		String str = "i like like like java do you like a java"; //����
////		String str = "do you love me?"; // �����λ ��Ϊ��
////		String str = "how do you d"; // ����λΪ��
//		System.out.println("��Ϣ��" + str);
//		
//		//1. ��ԭ�ַ���תΪbyte[]���飨ASCII�룩
//		byte[] bytes = str.getBytes();
//		
//		//ѹ��
//		byte[] huffmanBytes = huffmanZip(bytes);
//		
//		//���ѹ�����
//		System.out.print("ѹ����");
//		for (int i = 0; i < huffmanBytes.length; i++) {
//			System.out.print(huffmanBytes[i] + " ");
//		}
//		System.out.println();
//		
//		
//		//��ѹ
//		byte[] decodeBytes = decode(huffmanBytes);
//		System.out.println("���룺" + new String(decodeBytes));
		
		//-- ѹ���ļ�--
		huffmanZipFile("D://hei.mp4", "D://nihao.zip");
		
		//��ѹ�ļ�
		unzipFile("D://nihao.zip", "D://3.mp4");
	}
	
	/**
	 * �ļ�ѹ��
	 */
	private static void huffmanZipFile(String srcFile, String dstFile) {
		// IO��
		//�����ļ�������
		FileInputStream is = null;

		//�����ļ������
		FileOutputStream os = null;
		ObjectOutputStream oss = null;
		
		try {
			is = new FileInputStream(srcFile);
			
			byte[] bytes = new byte[is.available()]; // �����ļ���С��������
			
			is.read(bytes); //���ļ�����bytes��
			
			os = new FileOutputStream(dstFile);
			
			oss = new ObjectOutputStream(os);
			
			oss.writeObject(huffmanZip(bytes));
			
			oss.writeObject(HuffmanCodes);
			
			oss.writeObject(LastIndexLength);
		
		}catch (Exception e){
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				os.close();
				oss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	/**
	 * �ļ���ѹ
	 */
	public static void unzipFile(String zipFile, String dstFile) {
		FileInputStream is = null;
		ObjectInputStream ois = null;
		FileOutputStream os = null;
		
		try {
			is = new FileInputStream(zipFile);
			
			ois = new ObjectInputStream(is);
			
			byte[] huffmanBytes = (byte[])ois.readObject();
			
			Map<Byte, String> huffmanCodes = (Map<Byte, String>)ois.readObject();
			
			int lastIndexLength = (int)ois.readObject();
			
			HuffmanCode.HuffmanCodes = huffmanCodes;
			HuffmanCode.LastIndexLength = lastIndexLength;
			byte[] decodeBytes = decode(huffmanBytes);
			
			os = new FileOutputStream(dstFile);
			
			os.write(decodeBytes);
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}finally {
			try {
				is.close();
				ois.close();
				os.close();
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
		}
	}
	

	/**
	 * ���ݽ�ѹ
	 */
	public static byte[] decode(byte[] huffmanBytes) {
		//��ѹ
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {
			boolean flag = i == huffmanBytes.length - 1 ? true:false;
			String codes = byteToBitString(huffmanBytes[i], flag);
			stringBuilder.append(codes);
		}
		System.out.println("��ѹ��" + stringBuilder);
		
		
		//����
		
		//����map��value��key
		Map<String, Byte> huffmanDecodes = new HashMap<>();
		for (Entry<Byte, String> item : HuffmanCodes.entrySet()) {
			huffmanDecodes.put(item.getValue(), item.getKey());
		}
		
		
		String key = "";
		List<Byte> list = new ArrayList<>();
		for (int i = 0; i < stringBuilder.length(); i++) {
			key += stringBuilder.charAt(i);
			Byte b = huffmanDecodes.get(key);
			if (b != null) {
				list.add(b);
				key = "";
			}
		}
		
		byte[] bytes = new byte[list.size()];
		for (int i = 0; i <list.size(); i++) {
			bytes[i] = list.get(i);
		}
		return bytes;
	}
	
	//���ز��� ԭ��ת����
	public static String byteToBitString(byte b, boolean flag) {
		//���ض����ƶ�Ӧ�Ĳ��� Integer.toBinaryString()
		//������int���� Ҫת��byte
		//�����һ�����ضϰ�λ ���� |=�����λ
		//���һ���������ж� ���Ϊ������λ�� ���Ϊ����ضϰ�λ
		if (flag == false || (flag == true && b < 0)) {
			//����������һλ ���������һλ��Ϊ��
			int temp = b;
			temp |= 256; //�����λ
			String code = Integer.toBinaryString(temp);
			code = code.substring(code.length() - 8); //�ضϰ�λ
			return code;
		}
		else {
			//��������һλ��Ϊ�� ����λ������
			String code = Integer.toBinaryString(b);
			while (code.length() < LastIndexLength) {
				code = "0" + code;
			}
			
			return code;
		}
	}
	
	
	
	
	/**
	 * ����ѹ��
	 */
	public static byte[] huffmanZip(byte[] bytes) {
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
		System.out.println("���룺" + huffmanCodeString);
		
		//7. ѹ����ò����Ӧ��ԭ��ת����ʮ��������
		byte[] huffmanCodeBytes = zip(huffmanCodeString);
		
		return huffmanCodeBytes;
	}

	//������Ľڵ�
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
	
	static int LastIndexLength = 8;
	
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
				LastIndexLength = str.length();
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
