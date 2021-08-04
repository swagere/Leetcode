package oneDay.leetcode;

//³¬Ê±
public class l_611_1 {
	public static int triangleNumber(int[] nums) {
		int count = 0;
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i + 1; j < nums.length; j++) {
        		for (int k = j + 1; k < nums.length; k++) {
        			if (nums[i] + nums[j] > nums[k] && Math.abs(nums[i] - nums[j]) < nums[k]) {
        				count += 1;
        			}
        		}
        	}
        }
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {2,2,3,4};

		System.out.println(triangleNumber(nums));
	}

}
