package oneDay.offer;

public class o_36 {

	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		System.out.println(new Solution361().treeToDoublyList(root));
	}

}

//模仿线索化二叉树
class Solution361 {
	Node pre = null;
    public Node treeToDoublyList(Node root) {
    	if (root == null) {
    		return null;
    	}
    	translate(root);
    	
    	//新root
    	while (root.left != null) {
    		root = root.left;
    	}
    	pre.right = root;
    	root.left = pre;
    	
    	return root;
    }
    
    //线索化二叉树
    public void translate(Node n) {
    	//左
    	if (n.left != null) {
    		translate(n.left);
    	}
    	
    	//前驱节点赋值
    	if (pre != null) {
    		n.left = pre;
    		pre.right = n;
    	}
    	pre = n;
    	
    	
    	//右
    	if (n.right != null) {
    		translate(n.right);
    	}
    }
}
