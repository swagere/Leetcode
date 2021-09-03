package oneDay.meet;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//r
//´ó¶¥¶Ñ
public class m_1714_3 {
	public static int[] smallestK(int[] arr, int k) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		for (int i = 0; i < arr.length; i++) {
			if (i < k) {
				heap.add(arr[i]);
			}
			else if (heap.size() > 0){
				if (heap.peek() > arr[i]) {
					heap.remove();
					heap.add(arr[i]);
				}
			}
		}
		
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[k - i - 1] = heap.poll();
		}
		return res;
    }

	public static void main(String[] args) {
		int[] arr = {1,3,5,2};
		int k = 0;
		System.out.println(Arrays.toString(smallestK(arr, k)));

	}

}
