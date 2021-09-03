package oneDay.meet;

import java.util.Arrays;

//r
//1. 直接调用sort排序
public class m_1714_1 {
	public static int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

	public static void main(String[] args) {
		int[] arr = {1,3,4,5,2,4,6,8};
		int k = 4;
		System.out.println(Arrays.toString(smallestK(arr, k)));

	}

}
