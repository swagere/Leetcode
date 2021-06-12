package com;

import java.util.Scanner;

public class Main9 {

	public static void main(String[] args) {
		//--������--
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		
		//n̨���Ե�����
		int[] ability = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			ability[i] = in.nextInt();
		}
		
		//m��������
		int[][] tasks = new int[m + 1][4];
		for (int i = 1; i <= m; i++) {
			tasks[i][0] = in.nextInt();
			tasks[i][1] = in.nextInt();
			tasks[i][2] = in.nextInt();
			tasks[i][3] = in.nextInt();
		}
		
		//--ģ��--
		
		//Ϊÿ̨���Է���һ������
		int[][] cur_abi = new int[n + 1][1000];
		
		for (int i = 1; i <= m; i++) {
			//����
			if (i != 1) {
				for (int j = 1; j <= n; j++) {
					for (int k = 0; k < ability[j]; k++) {
						if (cur_abi[j][k] != 0) {
							cur_abi[j][k]--;
						}
					}
				}
			}
			
			//����
			int computer = tasks[i][1]; //����
			
			int no_used = 0; //���û�б��ù�������
			for (int j = 0; j < ability[computer]; j++) {
				if (cur_abi[computer][j] == 0) {
					no_used++;
				}
			}
			
			if (no_used >= tasks[i][3]) { //������Է��䣬��Ϊ���������
				int count = tasks[i][3];  //��Ҫ�����������
				for (int j = 0; j < ability[computer]; j++) {
					if (cur_abi[computer][j] == 0) {
						cur_abi[computer][j] = tasks[i][2]; //��Ϊ��ʱ
						count--;
					}
					if (count == 0) {
						break;
					}
				}
				
				//���ʣ������
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
