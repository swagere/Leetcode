package real.m4_16_360;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] points = new int[n];
		for (int i = 0; i < n; i++) {
			points[i] = in.nextInt();
		}
		System.out.println(getSum(points));
	}
	
	public static long getSum(int[] points) {
		long sum = 0;
		for (int i = 0; i < points.length; i++) {
			sum += points[i];
			for (int j = i + 1; j < points.length; j++) {
				sum += points[i] | points[j];
			}
		}
		return sum;
	}

}
