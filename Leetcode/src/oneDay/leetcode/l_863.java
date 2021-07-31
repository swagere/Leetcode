package oneDay.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//r
//用map保存父节点 从三个方向深搜（先序遍历）
public class l_863 {
	static TreeNode root = null;
	static Map<TreeNode, TreeNode> map = new HashMap<>();
	static List<Integer> list = new ArrayList<Integer>();
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		if (k == 0) {
			list.add(target.val);
			return list;
		}
		//记录父节点的值
		preOrderAndSetParent(root, null);
		
//		System.out.println(map);
		
		//以目标节点为根节点 进行三个方向的循环寻找 即左右上
		int[] step = new int[500];
		search(k, 0, target, step);
		
		return list.stream().distinct().filter(x->!x.equals(Integer.valueOf(target.val))).collect(Collectors.toList());
		
    }
	
	
	//从目标节点搜寻路径为k的点
	public static void search(int k, int cur, TreeNode node, int[] step) {
		System.out.println(node.val);
		if (step[node.val] > 0) {
			return;
		}
		
		int[] steps = Arrays.copyOf(step, 500);
		steps[node.val] += 1;
		
		if (cur == k) {
			list.add(node.val);
			return;
		}
		
		if (node.left != null) {
			search(k, cur + 1, node.left, steps);
		}
		
		if (node.right != null) {
			search(k, cur + 1, node.right, steps);
		}
		
		if(map.get(node) != null) {
			search(k, cur + 1, map.get(node), steps);
		}
	}
	
	//前序遍历
	private static void preOrderAndSetParent(TreeNode node, TreeNode pre) {
		//记录pre的父节点
		if (pre != null) {
			map.put(node, pre);
		}
		else {
			map.put(node, null);
		}
		
		if (node.left != null) {
			pre = node;
			preOrderAndSetParent(node.left, pre);
		}
		
		if (node.right != null) {
			pre = node;
			preOrderAndSetParent(node.right, pre);
		}
		
	}
	
	//--辅助方法--
	public static void main(String[] args) {
		Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
//		Integer[] nums = {0,1,null,null,2,null,3,null,4};
		int target_val = 3;
		int k = 0;
		
		TreeNode root = create(nums);
		
		preOrder(root);
		System.out.println();
		
		TreeNode target = preSearch(root, target_val);
		
		System.out.println(distanceK(root, target, k));
	}
	
	//前序搜索
	private static TreeNode preSearch(TreeNode node, int target_val) {
		TreeNode res = null;
		if (node.val == target_val) {
			return node;
		}
		else {
			if (node.left != null) {
				res = preSearch(node.left, target_val);
			}
			
			if (res != null) {
				return res;
			}
			
			if (node.right != null) {
				res = preSearch(node.right, target_val);
			}
			
			if (res != null) {
				return res;
			}
		}
		return null;
	}

	//前序遍历
	private static void preOrder(TreeNode node) {
		System.out.print(node);
		
		if (node.left != null) {
			preOrder(node.left);
		}
		
		if (node.right != null) {
			preOrder(node.right);
		}
		
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
