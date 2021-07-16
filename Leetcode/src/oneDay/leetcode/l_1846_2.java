package oneDay.leetcode;

//r
//时间复杂度:O(n)
//方法二：不排序 遍历数组，小于n计数，大于n时填补
//计数排序 + 贪心
public class l_1846_2 {
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		int n = arr.length;
		int[] cnt = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			if (arr[i] <= n) {
				cnt[arr[i]]++;
			}
			else {
				cnt[n]++; //将超过n的元素视作n
			}
		}
		
		int miss = 0;
		for (int i = 1; i <= n; i++) {
			if (cnt[i] == 0) {
				miss++;
			}
			
			if (cnt[i] > 1) {
				miss = miss - Math.min((cnt[i] - 1), miss); //因为小数不能变大，只有大数才能减少
			}
			
		}
		
		return n - miss;
    }

	public static void main(String[] args) {
		int[] arr = {2,2,1,2,1};
		System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
	}

}
