package oneDay.offer;

public class o_26 {
	public static void main(String args[]) {
		TreeNode A = new TreeNode(4);
		A.left = new TreeNode(2);
		A.right = new TreeNode(3);
		A.left.left = new TreeNode(4);
		A.left.right = new TreeNode(5);
		A.right.left = new TreeNode(6);
		A.right.right = new TreeNode(7);
		A.left.left.left = new TreeNode(8);
		A.left.left.right = new TreeNode(9);
		
		TreeNode B = new TreeNode(4);
		B.left = new TreeNode(8);
		B.right = new TreeNode(9);
		System.out.println(new Solution261().isSubStructure(A, B));
	}
}

//递归解决
class Solution261 {
	TreeNode aim;
	boolean r = false;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
    	if (A == null || B == null) {
    		return false;
    	}
    	aim = B;
    	
    	return compare(A, B);
    }
    
    //考虑a b分别为null的情况
    public boolean compare(TreeNode a, TreeNode b) {
    	if (b == null) {
    		return true;
    	}
    	if (a == null) {
    		return false;
    	}
    	
    	boolean res = false;
    	if (a.val == b.val) {
    		res = compare(a.left, b.left);
    		if (!r && res) res = compare(a.right, b.right);
    		
    	}
    	else {
    		res = compare(a.left, aim);
    		if (!res) res = compare(a.right, aim);
    		if (res) r = true;
    	}
    	return res;
    }
}



