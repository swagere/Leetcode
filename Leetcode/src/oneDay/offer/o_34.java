package oneDay.offer;

import java.util.ArrayList;
import java.util.List;

public class o_34 {
	public static void main(String args[]) {
//		TreeNode root = new TreeNode(5);
//		root.left = new TreeNode(4);
//		root.right = new TreeNode(8);
//		root.left.left = new TreeNode(11);
//		root.left.left.left = new TreeNode(7);
//		root.left.left.right = new TreeNode(2);
//		root.right.left = new TreeNode(13);
//		root.right.right = new TreeNode(4);
//		root.right.right.left = new TreeNode(5);
//		root.right.right.right = new TreeNode(1);
		TreeNode root = new TreeNode(-2);
		root.right = new TreeNode(-3);
		System.out.println(new Solution341().pathSum(root, -5));
	}
}

class Solution341 {
	List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
    	if (root == null) {
    		return new ArrayList<List<Integer>>();
    	}
    	List<Integer> nums = new ArrayList<>();
    	getSum(root, 0, target, nums);
    	
    	return res;
    }
    
    public void getSum(TreeNode n, int sum, int target, List<Integer> nums) {
    	if (n.left == null && n.right == null && sum + n.val == target) {
    		nums.add(n.val);
    		res.add(new ArrayList<>(nums));
    		nums.remove(nums.size() - 1);
    		return;
    	}
    	
    	if ((n.left == null && n.right == null)) {
    		return;
    	}
    	
    	nums.add(n.val);
    	sum += n.val;
    	if (n.left != null) {
    		getSum(n.left, sum, target, nums);
    	}
    	
    	if (n.right != null) {
    		getSum(n.right, sum, target, nums);
    	}
    	nums.remove(nums.size() - 1);
    }
}