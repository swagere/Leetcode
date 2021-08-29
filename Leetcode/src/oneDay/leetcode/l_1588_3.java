package oneDay.leetcode;


//r
//出现次数
public class l_1588_3 {
	public static int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int n = arr.length;
        int[] add = new int[n];
        for (int i = 0; i < n; i++) {
            add[i] = (n - i + 1) / 2;
            int behind = 0;
            int count = 0;
            for (int j = i - 1; j >= 0; j--) {
            	if ((i - j) % 2 != 0) {
            		count += 1;
            	}
            	behind += add[j] - count;
            }
            res += (add[i] + behind) * arr[i];
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
//		int[] arr = {1,2,3,4,5,6,7,8,9};
		System.out.println(sumOddLengthSubarrays(arr));

	}

}
