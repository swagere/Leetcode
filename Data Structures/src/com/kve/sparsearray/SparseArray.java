package com.kve.sparsearray;

public class SparseArray {

	public static void main(String[] args) {
		//构造原矩阵
		int[][] chess = new int[11][11];
		chess[2][3] = 1;
		chess[3][4] = 2;
		
		//输出原矩阵
		for (int[] raw : chess) {
			for (int i : raw) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
		
		//求出稀疏矩阵的大小sum
		int sum = 0;
		for (int[] raw : chess) {
			for (int i : raw) {
				if (i != 0) {
					sum++;
				}
			}
		}
		
		//构造稀疏矩阵
		int[][] sparseArray = new int[sum + 1][3];
		sparseArray[0][0] = 11;
		sparseArray[0][1] = 11;
		sparseArray[0][2] = sum;
		
		int count = 1;
		for (int i = 0; i < 11; i++) {
			for (int j = 0; j < 11; j++) {
				if (chess[i][j] != 0) {
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					sparseArray[count][2] = chess[i][j];
					count++;
				}
			}
		}
		
		//输出稀疏矩阵
		for (int i = 0; i < sum + 1; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(sparseArray[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
