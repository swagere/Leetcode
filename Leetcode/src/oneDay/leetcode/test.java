package oneDay.leetcode;

public class test {

	public static void main(String[] args) {
		int[] sorted = {2,4,6,8,10};
		int left = 0;
		int right = sorted.length;
		int mid = (left + right) / 2;
		while (left != mid) {
			if (9 > sorted[mid]) {
				left = mid + 1;
				mid = (left + right) / 2;
			}
			else if (9 < sorted[mid]){
				right = mid;
				mid = (left + right) / 2;
			}
			else {
				break;
			}
		}
		
		System.out.println(mid);
	}

}
