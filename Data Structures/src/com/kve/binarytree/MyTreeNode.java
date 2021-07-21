package com.kve.binarytree;

public class MyTreeNode {
	private int id;
	private String name;
	private MyTreeNode left = null;
	private MyTreeNode right = null;
	
	//�����������������ֶ�
	private int leftType = 0; //0Ϊ����/�ӽڵ� 1Ϊǰ���ڵ�
	private int rightType = 0; //0Ϊ����/�ӽڵ� 1Ϊ��̽ڵ�
	
	public MyTreeNode(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MyTreeNode getLeft() {
		return left;
	}

	public void setLeft(MyTreeNode left) {
		this.left = left;
	}

	public MyTreeNode getRight() {
		return right;
	}

	public void setRight(MyTreeNode right) {
		this.right = right;
	}
	
	public int getLeftType() {
		return leftType;
	}

	public void setLeftType(int leftType) {
		this.leftType = leftType;
	}

	public int getRightType() {
		return rightType;
	}

	public void setRightType(int rightType) {
		this.rightType = rightType;
	}
	
	@Override
	public String toString() {
		return "[ id:" + id + " name:" + name + " ]";
	}
	
	//ǰ����� ������
	public void preOrder() {
		System.out.println(this);
		
		if (this.left != null) {
			this.left.preOrder();
		}
		
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	//������� �����
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	
	//�������
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		
		
		if (this.right != null) {
			this.right.postOrder();
		}
		
		System.out.println(this);
	}

	
	//ǰ��������� ������
	public MyTreeNode preOrderSearch(int id) {
		System.out.println(1);
		if (this.id == id) {
			return this;
		}
		
		MyTreeNode res = null;
		if (this.left != null) { 
			res = this.left.preOrderSearch(id);
		}
		if (res != null) {
			return res;
		}
		
		if (this.right != null) {
			res = this.right.preOrderSearch(id);
		}
		return res;
	}
	
	//����������� �����
	public MyTreeNode infixOrderSearch(int id) {
		
		MyTreeNode res = null;
		if (this.left != null) { 
			res = this.left.infixOrderSearch(id);
		}
		if (res != null) {
			return res;
		}
		
		System.out.println(2);
		if (this.id == id) {
			return this;
		}
		
		if (this.right != null) {
			res = this.right.infixOrderSearch(id);
		}
		return res;
	}
	
	//����������� ���Ҹ�
	public MyTreeNode postOrderSearch(int id) {
		
		MyTreeNode res = null;
		if (this.left != null) { 
			res = this.left.postOrderSearch(id);
		}
		if (res != null) {
			return res;
		}	
		
		
		if (this.right != null) {
			res = this.right.postOrderSearch(id);
		}
		if (res != null) {
			return res;
		}
		
		System.out.println(3); //����Ƚϴ��� Ӧ�÷��ڱȽ�֮ǰ��׼ȷ ������ǰ�����ֻ���ж����Ƿ�Ϊ�ն�û�бȽ�
		if (this.id == id) {
			return this;
		}
		return res;
	}
	
	//ɾ���ڵ�1
	//ֻ���ҵ���ɾ���ڵ�ĸ��ڵ� Ȼ��ͨ�����ڵ��ָ��
	//�����ɾ���ڵ���Ҷ�ӽڵ� ��ֱ��ɾ���ýڵ�
	//�����ɾ���ڵ㲻��Ҷ�ӽڵ� ��ɾ����������
	//�޷���ֵ��
	public void delNode1(int id) {
		//���ж���ڵ� ���ж��ҽڵ�
		//��ѭ�������� ��ѭ��������
		if (this.left != null && this.left.id == id) {
			this.left = null;
			return;
		}
		
		if (this.right != null && this.right.id == id) {
			this.right = null;
			return;
		}
		
		if (this.left != null) {
			this.left.delNode1(id); // bug:�����������ɾ�� ���ǻ�ѭ����������ɾ��
		}
		
		if (this.right != null) {
			this.right.delNode1(id);
		}
	}
	
	//ɾ���ڵ�2
	//ֻ���ҵ���ɾ���ڵ�ĸ��ڵ� Ȼ��ͨ�����ڵ��ָ��
	//�����ɾ���ڵ���Ҷ�ӽڵ� ��ֱ��ɾ���ýڵ�
	//�����ɾ���ڵ㲻��Ҷ�ӽڵ� ��ɾ����������
	//�з���ֵ��
	public MyTreeNode delNode2(int id) {
		//���ж���ڵ� ���ж��ҽڵ�
		//��ѭ�������� ��ѭ��������
		MyTreeNode res = null;
		if (this.left != null && this.left.id == id) {
			res = this.left;
			this.left = null;
			return res;
		}
		
		if (this.right != null && this.right.id == id) {
			res = this.right;
			this.right = null;
			return res;
		}
		
		if (this.left != null) {
			res = this.left.delNode2(id); // bug:�����������ɾ�� ���ǻ�ѭ����������ɾ��
		}
		
		if (res == null) {
			if (this.right != null) {
				res = this.right.delNode2(id);
			}
		}
		return res;
	}
	
	//ɾ���ڵ�2
	//ֻ���ҵ���ɾ���ڵ�ĸ��ڵ� Ȼ��ͨ�����ڵ��ָ��
	//�����ɾ���ڵ���Ҷ�ӽڵ� ��ֱ��ɾ���ýڵ�
	//�����ɾ���ڵ㲻��Ҷ�ӽڵ� 
	//���ýڵ�ֻ��һ���ӽڵ� ���ɸ��ӽڵ�ֱ�Ӵ���
	//���������ӽڵ� �������ӽڵ����ԭ�ڵ�(�����Ȳ���)
	public MyTreeNode delNode3(int id) {
		//���ж���ڵ� ���ж��ҽڵ�
		//��ѭ�������� ��ѭ��������
		MyTreeNode res = null;
		if (this.left != null && this.left.id == id) {
			res = this.left;
			delete(this, 0); //0Ϊ�� 1Ϊ��
			return res;
		}
		
		if (this.right != null && this.right.id == id) {
			res = this.right;
			delete(this, 1);
			return res;
		}
		
		if (this.left != null) {
			res = this.left.delNode2(id); // bug:�����������ɾ�� ���ǻ�ѭ����������ɾ��
		}
		
		if (res == null) {
			if (this.right != null) {
				res = this.right.delNode2(id);
			}
		}
		return res;
	}

	private void delete(MyTreeNode node, int flag) {
		MyTreeNode cur = null;
		if (flag == 0) {
			cur = node.left;
			//�ж��ǲ����������ӽڵ�
			if (cur.getLeft() != null && cur.getRight() != null) {
				//���������ӽڵ� �������ӽڵ������ǰ�ڵ�
				node.left = cur.getLeft();
			}
			else if (cur.getLeft() != null) {
				node.left = cur.getLeft();
			}
			else if (cur.getRight() != null) {
				node.left = cur.getRight();
			}
			else {
				node.left = null;
			}
		}
		else {
			cur = node.right;
			//�ж��ǲ����������ӽڵ�
			if (cur.getLeft() != null && cur.getRight() != null) {
				//���������ӽڵ� �������ӽڵ������ǰ�ڵ�
				node.right = cur.getLeft();
			}
			else if (cur.getLeft() != null) {
				node.right = cur.getLeft();
			}
			else if (cur.getRight() != null) {
				node.right = cur.getRight();
			}
			else {
				node.right = null;
			}
		}
		
		
	}
}