package oneDay.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//r
//模拟 算法复杂度为O(n) 最坏的情况是每个点遍历
public class l_1104_1 {
	public static List<Integer> pathInZigZagTree(int label) {
		//算出层数
		int i = 0;
		int sum = 0;
        while (true) {
        	if (label > sum) {
        		i++;
        		sum += Math.pow(2, i);
        	}
        	else {
        		break;
        	}
        }
        
        //建立int数组
		int[] nums = new int[sum + 1];
        for (int j = 0; j <= i; j++) {
        	if (j % 2 == 0) {
        		//如果时偶数，则从左到右增大
        		for (int k = 0; k < Math.pow(2, j); k++) {
        			nums[(int) (Math.pow(2, j) + k) - 1] = (int) (Math.pow(2, j) + k);
        		}
        	}
        	else {
        		for (int k = 0; k < Math.pow(2, j); k++) {
        			nums[(int) (Math.pow(2, j) + k) - 1] = (int) (Math.pow(2, j + 1) - k - 1);
        		}
        	}
        }
        
        System.out.println(Arrays.toString(nums));
        
        //搜索
        List<Integer> res = new ArrayList<Integer>();
        res = search(nums, label, 0, res);
		return res;
    }

	private static List<Integer> search(int[] nums, int lable, int cur, List<Integer> res) {
		List<Integer> list = new ArrayList<>(res);
		list.add(nums[cur]);
		
		
		List<Integer> r = new ArrayList<>();
		
		if (nums[cur] == lable) {
			return list;
		}
		
		if (cur * 2 + 1 < nums.length) {
			r = search(nums, lable, cur * 2 + 1, list);
		}
		
		if (!r.isEmpty()) {
			return r;
		}
		
		if (cur * 2 + 2 < nums.length) {
			r = search(nums, lable, cur * 2 + 2, list);
		}
	
		return r;
	}

	public static void main(String[] args) {
		int label = 26;
		
		System.out.println(pathInZigZagTree(label));
	}

}
