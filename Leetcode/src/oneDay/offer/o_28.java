package oneDay.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o_28 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(3);
		System.out.println(new Solution282().isSymmetric(root));

	}

}
//·ÇµÝ¹é
class Solution281 {
    public boolean isSymmetric(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		Queue<TreeNode> q = new LinkedList<>();
    		List<Integer> nums = new ArrayList<>();
    		while (!queue.isEmpty()) {
    			TreeNode temp = queue.remove();
    			if (temp != null) {
    				nums.add(temp.val);
    				q.add(temp.left);
        			q.add(temp.right);
    			}
    			else {
                    nums.add(-1);
                }
    		}
    		List<Integer> temp = new ArrayList<>(nums);
    		Collections.reverse(nums);
    		if (!temp.equals(nums)) {
    			return false;
    		}
    		
    		queue = q;
    	}
    	return true;
    }
}

//µÝ¹é
class Solution282 {
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	return compare(root.left, root.right);
    }
    
    public boolean compare(TreeNode a, TreeNode b) {
    	if (a == null && b == null) {
    		return true;
    	}
    	
    	if (a == null || b == null) {
    		return false;
    	}
    	boolean res = false;
    	if (a.val == b.val) {
    		res = compare(a.left, b.right);
    		if (res) res = compare(a.right, b.left);
    	}
    	return res;
    }
}