package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

//r
//treemap+list实现
public class l_987 {
	static TreeNode root;
	static Map<Integer, Map<Integer, List<TreeNode>>> r = new TreeMap<>();
	
	public static List<List<Integer>> verticalTraversal(TreeNode root) {
		preOrder(root, 0, 0);
		List<List<Integer>> res = new ArrayList<>();
		

		for (Integer i : r.keySet()) {
			Map<Integer, List<TreeNode>> nodes = r.get(i);
			List<Integer> temp = new ArrayList<>();
			
			for (Integer index : nodes.keySet()) {
				for (TreeNode node : nodes.get(index)) {
					temp.add(node.val);
				}
			}
			
			res.add(temp);
		}

		return res;
    }
	
	//前序遍历
	private static void preOrder(TreeNode node, int x, int y) {
		
		Map<Integer, List<TreeNode>> map = r.getOrDefault(y, new TreeMap<>());
		List<TreeNode> list = map.getOrDefault(x, new ArrayList<>());
//		list.add(node);
		
		//按顺序添加
		if (list.isEmpty() || list.size() == 0) {
			list.add(node);
		}
		else {
			boolean flag = false;
			for (int i = 0; i < list.size(); i++) {
				if ((list.get(i).val < node.val && i + 1 < list.size() && list.get(i + 1).val > node.val) || (list.get(i).val < node.val && i + 1 == list.size())) {
					list.add(i + 1, node);
					flag = true;
					break;
				}
			}
			
			if (flag == false) {
				list.add(0, node);
			}
		}
		
		map.put(x, list);
		r.put(y, map);
		
		
		if (node.left != null) {
			preOrder(node.left, x + 1, y - 1);
		}
		
		if (node.right != null) {
			preOrder(node.right, x + 1, y + 1);
		}
		
	}

	
	//构造树的方法有问题
	public static void main(String[] args) {
//		Integer[] nums = {3,9,20,null,null,15,7};
		Integer[] nums = {0,2,1,3,null,5,22,9,4,12,25,null,null,13,14,8,6,null,null,null,null,null,27,24,26,null,17,7,null,28,null,null,null,null,null,19,null,11,10,null,null,null,23,16,15,20,18,null,null,null,null,null,21,null,null,29};
		
		create(nums);

		System.out.println(verticalTraversal(root));
	}
	
	//层次遍历转成前序遍历的二叉树
	public static TreeNode create(Integer[] nums) {
		root = new TreeNode(nums[0]);
		
		//向左递归
		create(nums, 1, root, 0);
		
		//向右递归
		create(nums, 2, root, 1);
		
		return root;
	}

	public static void create(Integer[] nums,int index, TreeNode cur, int flag) {
		if (cur == null) {
			return;
		}
		if (index < nums.length) {
			if (nums[index] == null) {
				return;
			}
			if (flag == 0) { //左
				cur.left = new TreeNode(nums[index]);
				//左递归
				create(nums, 2*index + 1, cur.left, 0);
				
				
				//右递归
				create(nums,2*index + 2, cur.left, 1);
			}
			else {
				cur.right = new TreeNode(nums[index]);
				//左递归
				create(nums, 2*index + 1, cur.right, 0);
				
				
				//右递归
				create(nums,2*index + 2, cur.right, 1);
			}
			
		}
	}
	
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    
    @Override
	public String toString() {
		return "[val=" + val + "]";
	}
 }