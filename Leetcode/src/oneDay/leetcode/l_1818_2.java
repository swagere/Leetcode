package oneDay.leetcode;

import java.util.Arrays;

//超时
//优化：二分查找
//思路一：先找出和，再依次找出不为0的每个的替换值，比较得出差距最大的替换值
//r
public class l_1818_2 {
	public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		int len = nums1.length;
		int[] gap = new int[len];
		int res = 0;
		int mod = 1000000007;
		
		int[] sorted = nums1.clone();
		Arrays.sort(sorted);
		
		
		//先找出所有差距值
		for (int i = 0; i < len; i++) {
			gap[i] = Math.abs(nums1[i] - nums2[i]) % mod;
			res = (res + gap[i]) % mod;
		}
		
		//替换差距值
		int t = res;
		for (int i = 0; i < len; i++) {
			if (gap[i] != 0) {
				//二分查找
				int target = nums2[i];
				int pivot = 0, left = 0, right = len - 1;
			    while (left <= right) {
			      pivot = left + (right - left) / 2;
			      if (sorted[pivot] == target) break;
			      if (target < sorted[pivot]) right = pivot - 1;
			      else left = pivot + 1;
			    }
			    
				int temp = Math.abs(sorted[pivot] - nums2[i]) % mod;
				if (pivot - 1 >= 0) {
					temp = Math.min(temp, Math.abs(sorted[pivot - 1] - nums2[i]) % mod);
				}
				if (pivot + 1 < len) {
					temp = Math.min(temp, Math.abs(sorted[pivot + 1] - nums2[i]) % mod);
					
				}
				if (res >= (t - gap[i] + temp) % mod) {
					res = (t - gap[i] + temp) % mod;
				}
			}
		}
		return (res + mod) % mod;
    }

	public static void main(String[] args) {
		int[] nums1 = {8,9,2};
		int[] nums2 = {7,7,3};
				
		System.out.println(minAbsoluteSumDiff(nums1, nums2));
	}

}
