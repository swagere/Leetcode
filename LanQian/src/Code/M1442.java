package Code;

import java.util.Scanner;

public class M1442 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		int length = 4*n + 5;
		
		char[][] res = new char[length][length];
		
		//先填全部
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				res[i][j] = '.';
			}
		}		
		
		//再填中心十字
		for (int i = 0; i < 5; i++) {
			res[2*n+2][2*n+i] = '$';
			res[2*n+i][2*n+2] = '$';
		}
		
		//每一层
		for (int i = 1; i <= n; i++) {
			//四周
			int xy_1 = 2*n - 2*i;
			int xy_2 = 2*n + 4 + 2*i;
			int count = 4*i + 1;
			int start = 2*n + 2 - (count - 1)/2;
			for (int j = 0; j < count; j++) {
				res[xy_1][start + j] = '$';
				res[xy_2][start + j] = '$';
				res[start + j][xy_1] = '$';
				res[start + j][xy_2] = '$';
			}
			
			//八点
			int end = start + count - 1;
			for (int j = 1; j < 3; j++) {
				res[xy_1 + j][start] = '$';
				res[xy_2 - j][start] = '$';
				res[start][xy_1 + j] = '$';
				res[start][xy_2 - j] = '$';
				
				res[xy_1 + j][end] = '$';
				res[xy_2 - j][end] = '$';
				res[end][xy_1 + j] = '$';
				res[end][xy_2 - j] = '$';
			}
		}
		
		
		
		//显示
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				System.out.print(res[i][j]);
			}
			if (i != length - 1) {
				System.out.println();
			}
		}
	}

}
