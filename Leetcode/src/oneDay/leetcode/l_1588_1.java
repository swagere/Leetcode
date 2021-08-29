package oneDay.leetcode;


//w
//�������⣺��ĿҪ��Ϊ����������
public class l_1588_1 {
	static int res = 0;
    public static int sumOddLengthSubarrays(int[] arr) {
        fun(0, 0, 0, arr);
        return res;
    }

    public static void fun(int index, int sum, int count, int[] arr) {
        for (int i = index; i < arr.length; i++) {
            sum += arr[i];
            count += 1;
            if (count % 2 != 0) {
                res += sum;
                System.out.println(res);
            }
            fun(i + 1, sum, count, arr);
            sum -= arr[i];
            count -= 1;
        }
    }

	public static void main(String[] args) {
		int[] arr = {1,4,2,5,3};
		System.out.println(sumOddLengthSubarrays(arr));

	}

}
