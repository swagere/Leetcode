package oneDay.offer;

public class o_68_¢ñ {

	public static void main(String[] args) {
		TreeNode p = new TreeNode(7);
		TreeNode q = new TreeNode(9);
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.left = p;
		root.right.right = q;
		
		System.out.println(new Solution6811().lowestCommonAncestor(root, p, q).val);

	}

}

class Solution6811 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	int min = Math.min(p.val, q.val);
    	int max = Math.max(p.val, q.val);
        if (root == null || root.val >= min && root.val <= max) {
        	return root;
        }
        
        if (root.val < min) {
        	return lowestCommonAncestor(root.right, p, q);
        }
    	return lowestCommonAncestor(root.left, p, q);
    }
}

//ÓÅ»¯
class Solution6812 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
        	return lowestCommonAncestor(root.right, p, q);
        }
        else if (root.val > p.val && root.val > q.val) {
        	return lowestCommonAncestor(root.left, p, q);
        }
    	return root;
    }
}