package oneDay.leetcode;

import java.util.Arrays;

//r
public class l_496 {
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                while (j < nums2.length && nums2[j] != nums1[i]) {
                    j += 1;
                }
                j += 1;
                while (j < nums2.length && nums2[j] < nums1[i]) {
                    j += 1;
                }
                if (j == nums2.length || j == nums2.length + 1) {
                    res[i] = -1;
                    break;
                }
                else {
                    res[i] = nums2[j];
                    break;
                }
            }
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums1 = {4,1,2};
		int[] nums2 = {1,3,4,2};
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));

	}

}
