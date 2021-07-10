package oneDay.meet;

//r


public class m_1710_3 {
	public static int majorityElement(int[] nums) {
		//摩尔投票 先计算出可能超过一半的元素
		//cur用于计量当前有重复的数 count用于计量个数 可不改变原nums数组
		
		int count = 0;
		int cur = -1;
		for (int i : nums) {
			if (count == 0) {
				cur = i;
				count++;
			}
			else {
				if (i == cur) {
					count++;
				}
				else {
					count--;
				}
			}
		}
		
		//确定是否超过一半
		count = 0;
		for (int i : nums) {
			if (i == cur) {
				count++;
			}
		}
		
		return count > nums.length / 2 ? cur : -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,5,9,5,9,5,5,5};
		System.out.println(majorityElement(nums));
	}

}
