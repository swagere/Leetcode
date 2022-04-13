package sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {4,6,1,3,5,4};
		sort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int l, int r) {
		if (l >= r) {
			return;
		}
		int mid = l + (r - l) / 2;
		sort(arr, l, mid);
		sort(arr, mid + 1, r);
		mergy(arr, l, r, mid);
	}

	private static void mergy(int[] arr, int l, int r, int mid) {
		int left = l;
		int right = mid + 1;
		int[] newArray = new int[r - l + 1];
		int i = 0;
		while (right <= r && left <= mid) {
			if (arr[left] < arr[right]) {
				newArray[i] = arr[left];
				i += 1;
				left += 1;
			}
			else {
				newArray[i] = arr[right];
				i += 1;
				right += 1;
			}
		}
		
		if (right <= r) {
			while (right <= r) {
				newArray[i] = arr[right];
				i += 1;
				right += 1;
			}
		}
		if (left <= mid){
			while (left <= mid) {
				newArray[i] = arr[left];
				i += 1;
				left += 1;
			}
		}
		
		
		for (i = 0; i < newArray.length; i++) {
			arr[l] = newArray[i];
			l += 1;
		}
	}
}
