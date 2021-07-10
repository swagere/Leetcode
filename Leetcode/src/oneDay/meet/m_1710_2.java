package oneDay.meet;


public class m_1710_2 {
	public static int majorityElement(int[] nums) {
		//摩尔投票 先计算出可能超过一半的元素
		//改变nums数组，无法确定最后留下的元素的总个数是否超过一半
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == -1) {
				continue;
			}
			else {
				for (int j = i + 1; j < nums.length; j++) {
					if (nums[i] != nums[j] && nums[j] != -1) {
						nums[i] = -1;
						nums[j] = -1;
						break;
					}
				}
			}
		}
		
		
		//X确定是否超过一半
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				return nums[i];
			}
		}
		
		return -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {3,3,4};
		System.out.println(majorityElement(nums));
	}

}
