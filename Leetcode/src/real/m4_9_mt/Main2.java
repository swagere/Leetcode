package real.m4_9_mt;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] heights = new int[n];
		for (int i = 0; i < n; i ++) {
			heights[i] = in.nextInt();
		}

		String[] names = new String[n];
		for (int i = 0; i < n; i ++) {
			names[i] = in.next();
		}
		
		quickSort(heights, names, 0, n - 1);
		
		for (int i = 0; i < n; i++) {
			System.out.print(names[i]);
			if (i != n - 1) {
				System.out.print(" ");
			}
		}
	}
	
	public static void quickSort(int[] heights, String[] names, int l, int r) {
		if (l >= r) {
			return;
		}
		int[] p = partition(heights, names, l, r);
		quickSort(heights, names, p[1] + 1, r);
		quickSort(heights, names, l, p[0] - 1);
	}

	private static int[] partition(int[] heights, String[] names, int l, int r) {
		int left = l - 1;
		int right = r;
		while (l < right) {
			if (heights[l] < heights[r]) {
				swap(heights, names, left + 1, l);
				left += 1;
				l += 1;
			}else if (heights[l] > heights[r]) {
				swap(heights, names, l, right - 1);
				right -= 1;
			}else {
				l += 1;
			}
		}
		swap(heights, names, right, r);
//		Arrays.sort(names, left + 1, right + 1);
		int size = right - (left + 1) + 1;
		for (int i = left + 1; i < size; i++) {
			for (int j = i + 1; j < size + 1; j++) {
				if (names[i].compareTo(names[j]) > 0) {
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		return new int[] {left + 1, right};
	}

	private static void swap(int[] heights, String[] names, int i, int j) {
		int temp = heights[i];
		heights[i] = heights[j];
		heights[j] = temp;
		
		String tem = names[i];
		names[i] = names[j];
		names[j] = tem;
		
	}

}
