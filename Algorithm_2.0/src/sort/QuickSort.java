package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] arr = {4,5,6,7,3,4,5,6,1,3,2,6};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void sort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int random = l + (int)((r - l) * Math.random());
//		System.out.println("r " + r + " l " + l + " random " + random);
		swap(arr, random, r);
		int[] p = partition(arr, l, r); //得出范围
		sort(arr, p[1] + 1, r);
		sort(arr, l, p[0] - 1);
	}

	private static int[] partition(int[] arr, int l, int r) {
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
	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

}
