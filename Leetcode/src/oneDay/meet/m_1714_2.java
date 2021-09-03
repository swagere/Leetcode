package oneDay.meet;

import java.util.Arrays;
import java.util.PriorityQueue;

//r
//Ð¡¶¥¶Ñ
public class m_1714_2 {
	public static int[] smallestK(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
		for (int i : arr) heap.add(i);
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = heap.poll();
		}
		return res;
    }

	public static void main(String[] args) {
		int[] arr = {1,3,4,5,2,4,6,8};
		int k = 4;
		System.out.println(Arrays.toString(smallestK(arr, k)));

	}

}
