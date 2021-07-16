package oneDay.leetcode;


//r
//时间复杂度:O(nlogn)
//法一：排序后强制大小 
//排序 + 贪心
public class l_1846_1 {
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		arr[0] = 1;
		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) > 1) {
				arr[i] = arr[i - 1] + 1;
				if (i + 1 == arr.length) {
					arr[i] = arr[i - 1] + 1;
				}
				else {
					if (arr[i + 1] - arr[i - 1] >= 0) {
						arr[i] = arr[i - 1] + 1;
					}
					else {
						arr[i] = arr[i - 1] - 1;
					}
				}
			}
		}
		
		//拿到最大值
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		
		return max;
    }

	public static void main(String[] args) {
		int[] arr = {100,1,1000};
		System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
	}

}
