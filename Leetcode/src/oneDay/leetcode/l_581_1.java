package oneDay.leetcode;

//r
//先找出没有按序递增或者递减的两个点
//确保中间的范围，即乱序的数组最左边的元素比左边所有元素大 最右边的元素比右边所有元素小
//确保方法：遍历中间的数组，调整边界位置
public class l_581_1 {

	public static int findUnsortedSubarray(int[] nums) {
		int low = 0;
		
		int high = nums.length - 1;
		
		boolean flag = false;
		
		//找到转折点
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				low = i;
				flag = true;
				break;
			}
		}
		
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] < nums[i - 1]) {
				high = i;
				flag = true;
				break;
			}
		}
		
		
		int l = low;
		int r = high;
		int min = nums[low];
		int max = nums[high];
		for (int i = l; i <= r; i++) {
			if (nums[i] < min) {
				//移动左指针
				while (low >= 0 && nums[i] < nums[low]) {
					low--;
				}
				min = low >= 0 ? nums[low]: min; 
			}
			
			if (nums[i] > max) {
				while (high < nums.length && nums[i] > nums[high]) {
					high++;
				}
				max = high < nums.length ? nums[high] : max;
			}
		}
		
		if (flag == false) {
			return 0;
		}
		
		return high - low - 1;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,1};
		
		System.out.println(findUnsortedSubarray(nums));

	}

}
