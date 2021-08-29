package oneDay.leetcode;


//r
//Ç°×ººÍ
public class l_1588_2 {
	public static int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if ((j - i + 1) % 2 != 0) {
                    res += sum;
                }
            }
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
		System.out.println(sumOddLengthSubarrays(arr));

	}

}
