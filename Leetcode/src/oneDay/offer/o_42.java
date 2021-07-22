package oneDay.offer;


//连续子数组的最大和
//线性dp
//空间优化：直接在nums上改，不额外开辟dp空间
public class o_42 {
	public static int maxSubArray(int[] nums) {
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] >= 0) {
				nums[i] = nums[i - 1] + nums[i];
			}
			max = Math.max(max, nums[i]);
		}
		
		return max;
    }


	public static void main(String[] args) {
		int[] nums = {-2,1};
		
		System.out.println(maxSubArray(nums));
	}

}
