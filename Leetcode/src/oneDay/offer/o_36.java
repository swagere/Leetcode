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

//ģ��������������
class Solution361 {
	Node pre = null;
    public Node treeToDoublyList(Node root) {
    	if (root == null) {
    		return null;
    	}
    	translate(root);
    	
    	//��root
    	while (root.left != null) {
    		root = root.left;
    	}
    	pre.right = root;
    	root.left = pre;
    	
    	return root;
    }
    
    //������������
    public void translate(Node n) {
    	//��
    	if (n.left != null) {
    		translate(n.left);
    	}
    	
    	//ǰ���ڵ㸳ֵ
    	if (pre != null) {
    		n.left = pre;
    		pre.right = n;
    	}
    	pre = n;
    	
    	
    	//��
    	if (n.right != null) {
    		translate(n.right);
    	}
    }
}
