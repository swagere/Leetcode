package oneDay.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class o_32_¢ò {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//¸¨Öú¶ÓÁÐ
class Solution322 {
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	if (root == null) {
    		return new ArrayList<>();
    	}
    	List<List<Integer>> result = new ArrayList<>();
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		Queue<TreeNode> temp = new LinkedList<>();
    		List<Integer> res = new ArrayList<>();
    		temp = queue;
    		queue = new LinkedList<>();
    		while (temp.size() > 0) {
    			TreeNode t = temp.poll();
    			res.add(t.val);
    			if (t.left != null) {
    				queue.add(t.left);
    			}
    			if (t.right != null) {
    				queue.add(t.right);
    			}
    		}
    		result.add(res);
    	}
    	return result;
    }
}
