package real.m9_9_xc;

import java.util.Scanner;

public class Main2 {
	static int min = Integer.MAX_VALUE;
	public static int findMin(int[] a, int n, int k) {
		if (n == k) {
			return 0;
		}
		
		int[][] gap = new int[k][2];
		
		dfs(a, n, k, 0, 0, gap);
		return min;
	}
	
	public static void dfs(int[] a, int n, int k, int index, int cur, int[][] gap) {
		if (cur == k) {
			int temp = Integer.MIN_VALUE;
			for (int i = 0; i < k - 1; i++) {
				temp = Math.max(gap[i][1] - gap[i][0], temp);
			}
			
			for (int i = index; i < n; i++) {
				if (a[i] < gap[k - 1][0]) {
					gap[k - 1][0] = a[i];
				}
				if (a[i] > gap[k - 1][1]) {
					gap[k - 1][1] = a[i];
				}
			}
			temp = Math.max(gap[k - 1][1] - gap[k - 1][0], temp);
			min = Math.min(min, temp);
//			System.out.println(Arrays.deepToString(gap));
			return;
		}
		
		for (int i = index; i < n; i++) {
			
			if (i == index) {
				gap[cur][0] = a[i];
				gap[cur][1] = a[i];
			}
			else {
				if (a[i] < gap[cur][0]) {
					gap[cur][0] = a[i];
				}
				if (a[i] > gap[cur][1]) {
					gap[cur][1] = a[i];
				}
			}
			
			
			dfs(a, n, k, i + 1, cur + 1, gap);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = in.nextInt();
		}
		
		System.out.println(findMin(a, n, k));
	}

}
