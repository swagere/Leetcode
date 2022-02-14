package oneDay.offer;

import java.util.ArrayList;
import java.util.List;

public class o_32_¢ó {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//¸¨Öú¶ÓÁÐ
class Solution323 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<>();
    	}
    	List<List<Integer>> result = new ArrayList<>();
    	List<TreeNode> queue = new ArrayList<>();
    	queue.add(root);
    	boolean flag = true;
    	while (!queue.isEmpty()) {
    		List<TreeNode> t = queue;
    		List<Integer> res = new ArrayList<Integer>();
    		queue = new ArrayList<>();
    		while (!t.isEmpty()) {
    			TreeNode temp = t.remove(0);
    			if (flag) {
    				res.add(temp.val);
    			}
    			else {
    				res.add(0, temp.val);
    			}
    			if (temp.left != null) {
					queue.add(temp.left);
    			}
    			if (temp.right != null) {
					queue.add(temp.right);
    			}
    		}
    		if (flag) {
				flag = false;
			}
			else {
				flag = true;
			}
    		result.add(res);
    	}
    	return result;
    }
}
