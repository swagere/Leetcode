package com.kve.binarytree;

public class MyTreeNode {
	private int id;
	private String name;
	private MyTreeNode left = null;
	private MyTreeNode right = null;
	
	//线索化二叉树新增字段
	private int leftType = 0; //0为子树/子节点 1为前驱节点
	private int rightType = 0; //0为子树/子节点 1为后继节点
	
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
	
	//前序遍历 根左右
	public void preOrder() {
		System.out.println(this);
		
		if (this.left != null) {
			this.left.preOrder();
		}
		
		if (this.right != null) {
			this.right.preOrder();
		}
	}
	
	//中序遍历 左根右
	public void infixOrder() {
		if (this.left != null) {
			this.left.infixOrder();
		}
		
		System.out.println(this);
		
		if (this.right != null) {
			this.right.infixOrder();
		}
	}
	
	
	//后序遍历
	public void postOrder() {
		if (this.left != null) {
			this.left.postOrder();
		}
		
		
		if (this.right != null) {
			this.right.postOrder();
		}
		
		System.out.println(this);
	}

	
	//前序遍历查找 根左右
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
	
	//中序遍历查找 左根右
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
	
	//后序遍历查找 左右根
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
		
		System.out.println(3); //计算比较次数 应该放在比较之前才准确 放在最前面可能只是判断了是否为空而没有比较
		if (this.id == id) {
			return this;
		}
		return res;
	}
	
	//删除节点1
	//只能找到待删除节点的父节点 然后通过父节点的指针
	//如果待删除节点是叶子节点 则直接删除该节点
	//如果待删除节点不是叶子节点 则删除整个子树
	//无返回值版
	public void delNode1(int id) {
		//先判断左节点 再判断右节点
		//再循环左子树 再循环右子树
		if (this.left != null && this.left.id == id) {
			this.left = null;
			return;
		}
		
		if (this.right != null && this.right.id == id) {
			this.right = null;
			return;
		}
		
		if (this.left != null) {
			this.left.delNode1(id); // bug:如果左子树已删除 还是会循环让右子树删除
		}
		
		if (this.right != null) {
			this.right.delNode1(id);
		}
	}
	
	//删除节点2
	//只能找到待删除节点的父节点 然后通过父节点的指针
	//如果待删除节点是叶子节点 则直接删除该节点
	//如果待删除节点不是叶子节点 则删除整个子树
	//有返回值版
	public MyTreeNode delNode2(int id) {
		//先判断左节点 再判断右节点
		//再循环左子树 再循环右子树
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
			res = this.left.delNode2(id); // bug:如果左子树已删除 还是会循环让右子树删除
		}
		
		if (res == null) {
			if (this.right != null) {
				res = this.right.delNode2(id);
			}
		}
		return res;
	}
	
	//删除节点2
	//只能找到待删除节点的父节点 然后通过父节点的指针
	//如果待删除节点是叶子节点 则直接删除该节点
	//如果待删除节点不是叶子节点 
	//若该节点只有一个子节点 则由改子节点直接代替
	//若有两个子节点 则用左子节点代替原节点(其余先不管)
	public MyTreeNode delNode3(int id) {
		//先判断左节点 再判断右节点
		//再循环左子树 再循环右子树
		MyTreeNode res = null;
		if (this.left != null && this.left.id == id) {
			res = this.left;
			delete(this, 0); //0为左 1为右
			return res;
		}
		
		if (this.right != null && this.right.id == id) {
			res = this.right;
			delete(this, 1);
			return res;
		}
		
		if (this.left != null) {
			res = this.left.delNode2(id); // bug:如果左子树已删除 还是会循环让右子树删除
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
			//判断是不是有两个子节点
			if (cur.getLeft() != null && cur.getRight() != null) {
				//若有两个子节点 则由左子节点替代当前节点
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
			//判断是不是有两个子节点
			if (cur.getLeft() != null && cur.getRight() != null) {
				//若有两个子节点 则由左子节点替代当前节点
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