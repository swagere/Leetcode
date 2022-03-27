package oneDay.offer;

import java.util.LinkedList;
import java.util.Queue;

public class o_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//∂”¡–
class Solution271 {
    public TreeNode mirrorTree(TreeNode root) {
    	Queue<TreeNode> queue = new LinkedList<>();
    	queue.add(root);
    	while (!queue.isEmpty()) {
    		TreeNode cur = queue.remove();
    		if (cur == null) {
    			continue;
    		}
    		TreeNode temp = cur.left;
    		cur.left = cur.right;
    		cur.right = temp;
    		queue.add(cur.left);
    		queue.add(cur.right);
    		
    	}
    	return root;
    }
}

//µ›πÈ
class Solution272 {
    public TreeNode mirrorTree(TreeNode root) {
    	reverse(root);
    	return root;
    }
    
    public void reverse(TreeNode n) {
    	if (n != null) {
    		TreeNode temp = n.right;
    		n.right = n.left;
    		n.left = temp;
    		
    		reverse(n.left);
        	reverse(n.right);
    	}
    }
}