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
		//--压缩字符串--
//		String str = "i like like like java do you like a java"; //样例
////		String str = "do you love me?"; // 不足八位 即为正
////		String str = "how do you d"; // 最后八位为负
//		System.out.println("消息：" + str);
//		
//		//1. 将原字符串转为byte[]数组（ASCII码）
//		byte[] bytes = str.getBytes();
//		
//		//压缩
//		byte[] huffmanBytes = huffmanZip(bytes);
//		
//		//输出压缩结果
//		System.out.print("压缩：");
//		for (int i = 0; i < huffmanBytes.length; i++) {
//			System.out.print(huffmanBytes[i] + " ");
//		}
//		System.out.println();
//		
//		
//		//解压
//		byte[] decodeBytes = decode(huffmanBytes);
//		System.out.println("解码：" + new String(decodeBytes));
		
		//-- 压缩文件--
		huffmanZipFile("D://hei.mp4", "D://nihao.zip");
		
		//解压文件
		unzipFile("D://nihao.zip", "D://3.mp4");
	}
	
	/**
	 * 文件压缩
	 */
	private static void huffmanZipFile(String srcFile, String dstFile) {
		// IO流
		//创建文件输入流
		FileInputStream is = null;

		//创建文件输出流
		FileOutputStream os = null;
		ObjectOutputStream oss = null;
		
		try {
			is = new FileInputStream(srcFile);
			
			byte[] bytes = new byte[is.available()]; // 根据文件大小创建数组
			
			is.read(bytes); //将文件读到bytes中
			
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
	 * 文件解压
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
	 * 数据解压
	 */
	public static byte[] decode(byte[] huffmanBytes) {
		//解压
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < huffmanBytes.length; i++) {
			boolean flag = i == huffmanBytes.length - 1 ? true:false;
			String codes = byteToBitString(huffmanBytes[i], flag);
			stringBuilder.append(codes);
		}
		System.out.println("解压：" + stringBuilder);
		
		
		//解码
		
		//调换map的value和key
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
	
	//返回补码 原码转补码
	public static String byteToBitString(byte b, boolean flag) {
		//返回二进制对应的补码 Integer.toBinaryString()
		//但是是int类型 要转成byte
		//非最后一个：截断八位 或者 |=补齐八位
		//最后一个：单独判断 如果为正则补齐位数 如果为负则截断八位
		if (flag == false || (flag == true && b < 0)) {
			//如果不是最后一位 或者是最后一位且为负
			int temp = b;
			temp |= 256; //补齐八位
			String code = Integer.toBinaryString(temp);
			code = code.substring(code.length() - 8); //截断八位
			return code;
		}
		else {
			//如果是最后一位且为正 按照位数补齐
			String code = Integer.toBinaryString(b);
			while (code.length() < LastIndexLength) {
				code = "0" + code;
			}
			
			return code;
		}
	}
	
	
	
	
	/**
	 * 数据压缩
	 */
	public static byte[] huffmanZip(byte[] bytes) {
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
		System.out.println("编码：" + huffmanCodeString);
		
		//7. 压缩获得补码对应的原码转换的十进制数组
		byte[] huffmanCodeBytes = zip(huffmanCodeString);
		
		return huffmanCodeBytes;
	}

	//获得树的节点
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
	
	static int LastIndexLength = 8;
	
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
				LastIndexLength = str.length();
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
