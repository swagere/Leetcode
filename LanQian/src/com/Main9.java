package com;

import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		//--读数据--
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		//n台电脑的算力
		int[] ability = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			ability[i] = in.nextInt();
		}
		
		//m个任务数
		int[][] tasks = new int[m + 1][4];
		for (int i = 1; i <= m; i++) {
			tasks[i][0] = in.nextInt();
			tasks[i][1] = in.nextInt();
			tasks[i][2] = in.nextInt();
			tasks[i][3] = in.nextInt();
		}
		
		//--模拟--
		
		//为每台电脑分配一个数组
		int[][] cur_abi = new int[n + 1][1000];
		
		for (int i = 1; i <= m; i++) {
			//回收
			if (i != 1) {
				for (int j = 1; j <= n; j++) {
					for (int k = 0; k < ability[j]; k++) {
						if (cur_abi[j][k] != 0) {
							cur_abi[j][k]--;
						}
					}
				}
			}
			
			//分配
			int computer = tasks[i][1]; //电脑
			
			int no_used = 0; //查出没有被用过的算力
			for (int j = 0; j < ability[computer]; j++) {
				if (cur_abi[computer][j] == 0) {
					no_used++;
				}
			}
			
			if (no_used >= tasks[i][3]) { //如果可以分配，就为其分配算力
				int count = tasks[i][3];  //需要被分配的算力
				for (int j = 0; j < ability[computer]; j++) {
					if (cur_abi[computer][j] == 0) {
						cur_abi[computer][j] = tasks[i][2]; //记为耗时
						count--;
					}
					if (count == 0) {
						break;
					}
				}
				
				//输出剩余算力
				int flag = 0;
				for (int j = 0; j < ability[computer]; j++) {
					if (cur_abi[computer][j] == 0) {
						flag++;
					}
				}
				System.out.println(flag);
			}
			else {
				System.out.println(-1);
			}
				
			
		}
		
	}

}
