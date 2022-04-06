package oneDay.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class o_40 {

	public static void main(String[] args) {
		int[] arr = {0,0,0,2,0,5};
		int k = 0;
		System.out.println(Arrays.toString(new Solution403().getLeastNumbers(arr, k)));

	}

}
//直接调用排序函数
class Solution401 {
	public int[] getLeastNumbers(int[] arr, int k) {
		new ArrayList<>().add(1);
		int[] res = new int[k];
		Arrays.sort(arr);
		for (int i = 0; i < k; i++) {
			res[i] = arr[i];
		}
		return res;
    }
}

//快排
class Solution402 {
	public int[] getLeastNumbers(int[] arr, int k) {
		quickSort(arr, 0, arr.length - 1, k);
		return Arrays.copyOf(arr, k);
    }
	
	public void quickSort(int[] arr, int l, int r, int k) {
		if (l >= r) {
			return;
		}
		//优化
		if (l >= k) {
			return;
		}
		int random = l + (int)((r - l) * Math.random());
		swap(arr, random, r);
		int[] p = partition(arr, l, r); //得出范围
		quickSort(arr, p[1] + 1, r, k);
		quickSort(arr, l, p[0] - 1, k);
	}

	private int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		while (l < more) {
			if (arr[l] < arr[r]) {
				swap(arr, l, less + 1);
				less += 1;
				l += 1;
			}
			else if (arr[l] > arr[r]) {
				swap(arr, l, more - 1);
				more -= 1;
			}
			else {
				l += 1;
			}
		}
		swap(arr, more, r);
		return new int[] {less + 1, more};
	}

	//将a和b位置上的数字换位置
	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}

//大顶堆
class Solution403 {
	public int[] getLeastNumbers(int[] arr, int k) {
		if (arr.length == 0 || k == 0) {
			return new int[] {};
		}
		PriorityQueue<Integer> heap = new PriorityQueue<>((v1, v2) -> v2 - v1);
		for (int i : arr) {
			if (heap.size() < k) {
				heap.offer(i);
			}
			else {
				if (i < heap.peek()) {
					heap.poll();
					heap.offer(i);
				}
			}
		}
		
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = heap.poll();
		}
		return res;
    }
}