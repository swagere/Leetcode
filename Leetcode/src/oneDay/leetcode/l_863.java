package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//w
public class l_863 {
	static TreeNode root = null;
	static List<Integer> res = new ArrayList<>();
	
	public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		//1. ���ڵ����Ͼ���Ϊk�ĵ�
		int len = getLengthFromRoot(root, target);
		
		//���㸸�ڵ㵽Ŀ��ڵ�ľ���
		if (len == -1) {
			System.out.println("û�ҵ�");
		}
		else {
			System.out.println("len:" + len);
		}
		
		//���len����k�����Ӹ��ڵ������len-k���������ٹ�k���ڵ��ܷ��ҵ�Ŀ��ڵ�
		if (len >= k) {
			searchChild1(len - k, 0, root);
		}
		else {
			//���С��k����Ӹ��ڵ�������k-len�����������ٹ�k
//			searchChild(len - k, 0, root);
		}
		
		
		//2. �ӽ���о���Ϊk�ĵ�
		searchChild(k, 0, target);
		
		res.remove(Integer.valueOf(target.val));
		
		return res;
		
    }
	
	private static int getLengthFromRoot(TreeNode root, TreeNode target) {
		int len = getLengthFromRoot(root, target, 0);
		return len;
	}
	
	private static int getLengthFromRoot(TreeNode node, TreeNode target, int cur) {
		int res = -1;
		if (node.val == target.val) {
			return cur;
		}
		
		if (node.left != null) {
			res =  getLengthFromRoot(node.left, target, cur + 1);
		}
		
		if (res != -1) {
			return res;
		}
		
		if (node.right != null) {
			res =  getLengthFromRoot(node.right, target, cur + 1);
		}
		
		return res;
	}
	

	//��Ŀ��ڵ�������Ѱ·��Ϊk�ĵ�
	public static void searchChild(int k, int cur, TreeNode node) {
		if (cur == k) {
			res.add(node.val);
			return;
		}
		
		if (node.left != null) {
			searchChild(k, cur + 1, node.left);
		}
		
		if (node.right != null) {
			searchChild(k, cur + 1, node.right);
		}
	}
	
	//�Ӹ��ڵ���������·��Ϊlen-k��ֵ������֤
	public static void searchChild1(int k, int cur, TreeNode node) {
		if (cur == k) {
			//��֤�Ƿ��پ������µ�k�ξͿ�������Ŀ��ڵ�
			if (checkK(k, 0, node) == 1) {
				res.add(node.val);
				return;
			}
		}
		
		if (node.left != null) {
			searchChild(k, cur + 1, node.left);
		}
		
		if (node.right != null) {
			searchChild(k, cur + 1, node.right);
		}
	}
	
	public static int checkK(int k, int cur, TreeNode node) {
		if (cur == k) {
			return 1;
		}
		
		int res = -1;
		
		if (node.left != null) {
			res = checkK(k, cur + 1, node.left);
		}
		
		if (res == 1) {
			return 1;
		}
		
		if (node.right != null) {
			res = checkK(k, cur + 1, node.right);
		}
		
		return res;
	}

	//--��������--
	public static void main(String[] args) {
//		Integer[] nums = {3,5,1,6,2,0,8,null,null,7,4};
		Integer[] nums = {5,0,4,2,1,null,null,null,null,3,null};
		int target_val = 3;
		int k = 3;
		
		TreeNode root = create(nums);
		
		preOrder(root);
		System.out.println();
		
		TreeNode target = preSearch(root, target_val);
		
		System.out.println(distanceK(root, target, k));
	}
	
	//ǰ������
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

	//ǰ�����
	private static void preOrder(TreeNode node) {
		System.out.print(node);
		
		if (node.left != null) {
			preOrder(node.left);
		}
		
		if (node.right != null) {
			preOrder(node.right);
		}
		
	}

	//��α���ת��ǰ������Ķ�����
	public static TreeNode create(Integer[] nums) {
		root = new TreeNode(nums[0]);
		
		//����ݹ�
		create(nums, 1, root, 0);
		
		//���ҵݹ�
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
			if (flag == 0) { //��
				cur.left = new TreeNode(nums[index]);
				//��ݹ�
				create(nums, 2*index + 1, cur.left, 0);
				
				
				//�ҵݹ�
				create(nums,2*index + 2, cur.left, 1);
			}
			else {
				cur.right = new TreeNode(nums[index]);
				//��ݹ�
				create(nums, 2*index + 1, cur.right, 0);
				
				
				//�ҵݹ�
				create(nums,2*index + 2, cur.right, 1);
			}
			
		}
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
	
	@Override
	public String toString() {
		return "[val=" + val + "] => ";
	}
	
}