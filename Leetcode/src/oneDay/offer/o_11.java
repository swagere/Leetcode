package oneDay.offer;

public class o_11 {

	public static void main(String[] args) {
		int[] nums = {1,3,5};
		System.out.println(Solution112.minArray(nums));

	}

}

//顺序查找
class Solution111 {
	public static int minArray(int[] numbers) {
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i - 1] > numbers[i]) {
				return numbers[i];
			}
		}
		return numbers[0];
    }
}

//二分查找
class Solution112 {
	public static int minArray(int[] numbers) {
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (numbers[left] > numbers[mid]) {
				right = mid;
			}
			else if (numbers[right] < numbers[mid]) {
				left = mid + 1;
			}
			else {
				right --;
			}
		}
		return numbers[left];
    }
}
