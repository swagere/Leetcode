package oneDay.offer;

import java.util.LinkedList;
import java.util.Queue;

public class o_13 {

	public static void main(String[] args) {
		int m = 49;
		int n = 49;
		int k = 18;
		System.out.println(new Solution132().movingCount(m, n, k));
	}

}

//DFS+ºÙ÷¶
class Solution131 {
	int count = 0;
    public int movingCount(int m, int n, int k) {
    	int[][] visit = new int[m][n];
    	getRange(visit, m, n, 0, 0, k);
    	return count;
    }
    
    public void getRange(int[][] visit, int m, int n, int a, int b, int k) {
    	if (a < 0 || a >= m || b < 0 || b >= n || visit[a][b] != 0 || getSum(a, b) > k) {
    		return;
    	}
    	count += 1;
    	visit[a][b] = 1;
    	getRange(visit, m, n, a + 1, b, k);
    	getRange(visit, m, n, a, b + 1, k);
    	getRange(visit, m, n, a - 1, b, k);
    	getRange(visit, m, n, a, b - 1, k);
    }

	public int getSum(int a, int b) {
		int sum = 0;
		while (a > 9) {
			sum += a % 10;
			a = (a - a % 10) / 10;
		}
		sum += a;
		while (b > 9) {
			sum += b % 10;
			b = (b - b % 10) / 10;
		}
		sum += b;
		return sum;
	}
}

//BFS
class Solution132 {
    public int movingCount(int m, int n, int k) {
    	int count = 0;
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {0,0});
    	int[][] visit = new int[m][n];
    	visit[0][0] = 1;
    	while (!queue.isEmpty()) {
    		int[] loc = queue.remove();
    		count += 1;
    		int a = loc[0];
    		int b = loc[1];
    		if (a + 1 < m && getSum(a + 1, b) <= k && visit[a + 1][b] == 0) {
    			queue.add(new int[] {a + 1, b});
    			visit[a + 1][b] = 1;
    		}
    		if (b + 1 < n && getSum(a, b + 1) <= k && visit[a][b + 1] == 0) {
    			queue.add(new int[] {a, b + 1});
    			visit[a][b + 1] = 1;
    		}
    	}
    	return count;
    }
    
    public int getSum(int a, int b) {
		int sum = 0;
		while (a > 9) {
			sum += a % 10;
			a = (a - a % 10) / 10;
		}
		sum += a;
		while (b > 9) {
			sum += b % 10;
			b = (b - b % 10) / 10;
		}
		sum += b;
		return sum;
	}
}