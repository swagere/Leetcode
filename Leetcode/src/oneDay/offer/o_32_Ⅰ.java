package oneDay.offer;

import java.util.ArrayList;
import java.util.List;

public class o_32_¢Ò {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//∂”¡– bfs
class Solution321 {
    public static int[] levelOrder(TreeNode root) {
    	if (root == null) {
            return new int[0];
        }
    	List<TreeNode> cur = new ArrayList<>();
    	List<Integer> res = new ArrayList<>();
    	cur.add(root);
    	while (cur.size() > 0) {
    		TreeNode temp = cur.remove(0);
    		res.add(temp.val);
    		if (temp.left != null) {
    			cur.add(temp.left);
    		}
    		if (temp.right != null) {
    			cur.add(temp.right);
    		}
    	}
    	return res.stream().mapToInt(Integer::valueOf).toArray();
    }
}
