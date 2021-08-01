package dynamic;

import java.util.Arrays;

public class KnapsackProblem {

	public static void main(String[] args) {
		int n = 3; // 物品个数
		int m = 4; // 背包容量
		int[] w = {1,4,3}; // 物品重量
		int[] val = {1500, 3000, 4000}; // 物品价值

		int[][] v = new int[n + 1][m + 1];
		int[][] path = new int[n + 1][m + 1];
		
		//初始化数组
		for (int i = 0; i < v.length; i++) {
			v[i][0] = 0; // 第一列初始化为0
		}
		
		for (int i = 0; i < v[0].length; i++) {
			v[0][i] = 0; // 第一行初始化为0
		}
		
		for (int i = 1; i < v.length; i++) {
			for (int j = 1; j < v[0].length; j++) {
				if (w[i - 1] > j) {
					//如果不能放下当前物品 则直接继承上一行最优解
					v[i][j] = v[i - 1][j];
				}
				else {
					//如果能放下当前物品
					if (v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
						v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
						path[i][j] = 1;
					}
					else {
						v[i][j] = v[i - 1][j];
					}
				}
			}
		}
		
		
		// 输出
		for (int i = 0; i < v.length; i++) {
			System.out.println(Arrays.toString(v[i]));
		}
		
		int i = path.length - 1;
		int j = path[0].length - 1;
		while (i >= 0 && j >= 0) {
			if (path[i][j] == 1) {
				System.out.print(i + " ");
				j -= w[i - 1];
			}
			i--;
		}
	}

}
