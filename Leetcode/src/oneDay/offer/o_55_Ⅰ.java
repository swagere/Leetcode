package oneDay.offer;

public class o_55_�� {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(new Solution5511().maxDepth(root));
	}

}

class Solution5511 {
	//���ı���-�������
	int height = 0;
    public int maxDepth(TreeNode root) {
    	order(root, 0);
    	return height;
    }
    
    public void order(TreeNode node, int n) {
    	if (node == null) {
    		height = Math.max(height, n);
    		return;
    	}
    	
    	order(node.left, n + 1);
    	order(node.right, n + 1);
    }
}