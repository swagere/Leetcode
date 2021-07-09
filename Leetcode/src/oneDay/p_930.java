package oneDay;

//r
//±©Á¦Ñ­»·
public class p_930 {
	public static int numSubarraysWithSum(int[] nums, int goal) {
		int count = 0;
		
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum = sum + nums[j];
				if (sum == goal) {
					count++;
				}
				else {
					if (sum - nums[j] == goal) {
						break;
					}
				}
			}
		}
		
		return count; 
    }

	public static void main(String[] args) {
		int[] nums = {0,0,0,0,0};
		int goal = 0;
		System.out.println(numSubarraysWithSum(nums, goal));

	}

}
