package com;

import java.util.HashSet;
import java.util.Set;

public class Main5 {

	public static void main(String[] args) {
		int n = 2022;
		int[][] w = new int[n][n];
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < n; j++) {
				Set<Integer> temp = new HashSet<Integer>();
				int x = i;
				int y = j;
				while (x > 10) {
					temp.add(x % 10);
					x = (x - (x%10)) / 10;
				}
				temp.add(x);
				while (y > 10) {
					temp.add(y % 10);
					y = (y - (y%10)) / 10;
				}
				temp.add(y);
				
				//相加
				int sum = 0;
				for (Integer k : temp) {
					sum += k;
				}
				
				w[i][j] = sum;
				w[j][i] = sum;
			}
		}
		
		for (int k = 1; k < n; k++) {
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if (w[i][k] + w[k][j] < w[i][j]) {
						w[i][j] = w[i][k] + w[k][j];
					}
				}
			}
		}
			
		long sum = 0;
		int max = w[1][1];
		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (w[i][j] > max) {
					max = w[i][j];
				}
//				System.out.println("f[" + i + "][" + j + "] = " + w[i][j]);
				sum += w[i][j];
			}
		}
		System.out.println(max);
		System.out.println(sum);
		
		for (int i = 1; i <= 2021; i++) {
			for (int j = 1; j <= 2021; j++) {
				
			}
		}
		
//		//输出方格
//		for (int i = 1; i < n; i++) {
//			for (int j = i; j < n; j++) {
//				System.out.print(w[i][j] + "\t");
//			}
//			System.out.println();
//		}
	}

}
