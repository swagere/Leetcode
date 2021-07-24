package com.kve.binarysorttree;

public class BinarySortTree {
	private static Node root;

	public static void main(String[] args) {
		int[] nums = {7,3,10,12,5,1,9,0};
//		int[] nums = {1};
		
		//��������������
		for (int i : nums) {
			add(i);
		}
		
		//���������ӡ
		infixOrder();
		System.out.println();
		
		delNode(7);

		//���������ӡ
		infixOrder();
	}

	//�������
	public static void infixOrder() {
		if (root == null) {
			System.out.println("null");
		}
		else {
			root.infixOrder();
		}
	}
	
	//����/�����ڵ�
	public static void add(int val) {
		if (root == null) {
			root = new Node(val);
		}
		else {
			root.add(val);
		}
	}
	
	//ɾ���ڵ�
	public static void delNode(int val) {
		//--1. �ҵ���ɾ���ڵ����丸�ڵ�----------------------------------------
		//���жϸ��ڵ��Ƿ�Ϊ��
		if (root == null) {
			System.out.println("null! Can not delete!");
			return;
		}
		//�ҵ���ǰ�ڵ�ĸ��ڵ�
		Node parent = getParent(val);
		Node target = null;
		int dir = -1;
		
		//�жϸ��ڵ��Ƿ�Ϊ��
		if (parent == null) {
			//������ڵ㲻����val ��˵��û���ҵ�
			if (root.value != val) {
				System.out.println("û���ҵ��ýڵ�");
				return;
			}
			else {
				//���ڵ�ΪĿ��ڵ�
				target = root;
			}
		}
		else {
			//������ڸ��ڵ� ��˵��һ���ҵ�
			//�洢target�ڵ�
			if (parent.left != null && parent.left.value == val) {
				target = parent.left;
				dir = 0; //targetΪ���ӽڵ�
			}
			else if (parent.right != null && parent.right.value == val){
				target = parent.right;
				dir = 1; //targetΪ���ӽڵ�
			}
			else {
				System.out.println("û���ҵ��ýڵ�");
				return;
			}
		}
		
//		System.out.println("parent:" + parent);
//		System.out.println("target:" + target);
//		if(dir == 0) System.out.println("��"); else if(dir == 1) System.out.println("��"); else System.out.println("no root");
		
		//--2. �ж�������� Ҷ�ӽڵ� һ���ӽڵ� �����ӽڵ�--------------------------------------------
		if (target.left == null && target.right == null) {
			//�����Ҷ�ӽڵ�
			if (dir == -1) {
				//����Ǹ��ڵ� ��������˵��ֻ�и��ڵ�
				root = null;
			}
			else if (dir == 0){
				//��������
				parent.left = null;
			}
			else {
				parent.right = null;
			}
		}
		else if (target.left != null && target.right != null) {
			//���������Ҷ�ӽڵ�
			//�ҵ��������������滻
			Node temp = target.left;
			while (temp.right != null) {
				temp = temp.right;
			}
			delNode(temp.value);
			
			if (dir == -1) {
				//����Ǹ��ڵ� ��������˵��ֻ�и��ڵ�
				root.value = temp.value;
			}
			else if (dir == 0){
				//��������
				parent.left.value = temp.value;
			}
			else {
				parent.right.value = temp.value;
			}
			
		}
		else {
			//�����һ��Ҷ�ӽڵ�
			if (target.left != null) {
				if (dir == -1) {
					//����Ǹ��ڵ� ��������˵��ֻ�и��ڵ�
					root = target.left;
				}
				else if (dir == 0){
					//��������
					parent.left = target.left;
				}
				else {
					parent.right = target.left;
				}
			}
			else {
				if (dir == -1) {
					//����Ǹ��ڵ� ��������˵��ֻ�и��ڵ�
					root = target.right;
				}
				else if (dir == 0){
					//��������
					parent.left = target.right;
				}
				else {
					parent.right = target.right;
				}
			}
		}
	}
	
	//����Ҫɾ���ڵ�ĸ��ڵ�
	public static Node getParent(int val) {
		if (root == null) {
			return null;
		}
		else {
			return root.getParent(val);
		}
	}
}
