package oneDay.leetcode;

import java.util.Arrays;

//w
//只有贪心，思路错误
public class l_1818_1 {
	public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
		int len = nums1.length;
		int[] gap = new int[len];
		int res = 0;
		int mod = 1000000007;
		
		
		//先找出所有差距值
		for (int i = 0; i < len; i++) {
			gap[i] = Math.abs(nums1[i] - nums2[i]);
			res = (res + gap[i])%mod;
		}
		
		Arrays.sort(gap);
		
		//替换差距值
		int t = res;
		for (int i = len - 1; i >= 0; i--) {
			if (gap[i] != 0) {
				int k = 0;
				int g = Math.abs(nums1[0] - nums2[0]);
				while (g != gap[i] && k < len) {
					k++;
					g = Math.abs(nums1[k] - nums2[k]);
				}
				
				int min = Math.abs(nums1[0] - nums2[k]);
				for (int j = 1; j < len; j++) {
					if (Math.abs(nums1[j] - nums2[k]) < min) {
						min = Math.abs(nums1[j] - nums2[k]);
					}
				}
				
				int temp = (t - gap[i] + min)%mod;
				if (res > temp) {
					res = temp;
					break;
				}
			}
		}
		
		return res;
    }

	public static void main(String[] args) {
		int[] nums1 = {5,2,7};
		int[] nums2 = {10,7,12};
		System.out.println(minAbsoluteSumDiff(nums1, nums2));
	}

}
