package oneDay.offer;

public class o_42 {

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(Solution422.maxSubArray(nums));
	}

}

//动态规划
class Solution421 {
    public static int maxSubArray(int[] nums) {
    	int len = nums.length;
    	if (len == 0) {
    		return 0;
    	}
    	int[] sum = new int[len];
    	int max = nums[0];
    	sum[0] = nums[0];
    	for (int i = 1; i < len; i++) {
    		sum[i] = Math.max(nums[i], sum[i - 1] + nums[i]);
    		if (sum[i] > max) {
    			max = sum[i];
    		}
    	}
    	return max;
    }
}

//优化 动态规划
class Solution422 {
    public static int maxSubArray(int[] nums) {
    	int len = nums.length;
    	if (len == 0) {
    		return 0;
    	}
    	int max = nums[0];
    	int temp = nums[0];
    	for (int i = 1; i < len; i++) {
    		temp = Math.max(nums[i], temp + nums[i]);
    		if (temp > max) {
    			max = temp;
    		}
    	}
    	return max;
    }
}