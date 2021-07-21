package com.kve.binarytree;

public class BinaryTree {
	private MyTreeNode root;

	public MyTreeNode getRoot() {
		return root;
	}

	public void setRoot(MyTreeNode root) {
		this.root = root;
	}
	
	//前序遍历
	public void preOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.preOrder();
	}
	
	//中序遍历
	public void infixOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.infixOrder();
	}
	
	//后序遍历
	public void postOrder() {
		if (this.root == null) {
			System.out.println("null");
			return;
		}
		this.root.postOrder();
	}
	
	//前序遍历查找
	public MyTreeNode preOrderSearch(int id) {
		if (this.root != null) {
			return this.root.preOrderSearch(id);
		}
		
		return null;
	}
	
	//中序遍历查找
	public MyTreeNode infixOrderSearch(int id) {
		if (this.root != null) {
			return this.root.infixOrderSearch(id);
		}
		
		return null;
	}
	
	//后序遍历查找
	public MyTreeNode postOrderSearch(int id) {
		if (this.root != null) {
			return this.root.postOrderSearch(id);
		}
		
		return null;
	}
	
	//删除
	//先判断树是否为空
	//再判断根节点
	public void delNode1(int id) {
		if (this.root != null) {
			if (root.getId() == id) {
				root = null;
			}
			else {
				this.root.delNode1(id);
			}
		}
		else {
			System.out.println("该树为空 无法删除节点");
		}
	}
	
	public void delNode2(int id) {
		if (this.root != null) {
			if (root.getId() == id) {
				this.root = null;
			}
			else {
				MyTreeNode res = this.root.delNode2(id);
				if (res == null) {
					System.out.println("没有找到该节点 删除失败");
				}
				else {
					res.preOrder();
				}
			}
		}
		else {
			System.out.println("该树为空 无法删除节点");
		}
	}
	
	public void delNode3(int id) {
		if (this.root != null) {
			if (root.getId() == id) {
				//判断是否有两个子节点
				if (this.root.getLeft() != null && this.root.getRight() != null) {
					//若有两个子节点 则由左子节点替代当前节点
					this.root = this.root.getLeft();
				}
				else if (this.root.getLeft() != null) {
					this.root = this.root.getLeft();
				}
				else if (this.root.getRight() != null) {
					this.root = this.root.getRight();
				}
			}
			else {
				MyTreeNode res = this.root.delNode3(id);
				if (res == null) {
					System.out.println("没有找到该节点 删除失败");
				}
				else {
					System.out.println(res);
				}
			}
		}
		else {
			System.out.println("该树为空 无法删除节点");
		}
	}
}