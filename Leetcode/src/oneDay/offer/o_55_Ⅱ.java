package oneDay.offer;

public class o_55_¢ò {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(new Solution5521().isBalanced(root));
	}

}

class Solution5521 {
	boolean res = true;
    public boolean isBalanced(TreeNode root) {
    	order(root);
    	return res;
    }
    
    public int order(TreeNode node) {
    	if (node == null) {
    		return 0;
    	}
    	
    	if (res == false) {
    		return -1;
    	}
    	
    	int l = order(node.left);
    	int r = order(node.right);
    	if (Math.abs(l - r) > 1) {
    		res = false;
    	}
    	return Math.max(l, r) + 1;
    }
}