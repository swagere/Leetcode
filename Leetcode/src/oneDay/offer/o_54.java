package oneDay.offer;

import java.util.ArrayList;
import java.util.List;

public class o_54 {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);
		System.out.println(new Solution542().kthLargest(root, 4));
	}

}

//中序遍历
class Solution541 {
	List<Integer> sort = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
    	sortTree(root);
    	System.out.println(sort);
    	return sort.get(sort.size() - k);
    }
    
    //中序遍历
    public void sortTree(TreeNode n) {
    	if (n == null) {
    		return;
    	}
    	sortTree(n.left);
    	sort.add(n.val);
    	sortTree(n.right);
    }
}

//逆中序遍历+提前返回
class Solution542 {
	int sort = 1;
	int val = 0;
    public int kthLargest(TreeNode root, int k) {
    	sortTree(root,k);
    	return val;
    }
    
    //逆中序遍历
    public boolean sortTree(TreeNode n, int k) {
    	if (n == null) {
    		return false;
    	}
    	
    	boolean res = false;
    	res = sortTree(n.right, k);
    	
    	if (!res && sort == k) {
    		val = n.val;
    		return true;
    	}
    	if (!res) {
    		sort += 1;
    		res = sortTree(n.left, k);
    	}
    	return res;
    }
}
