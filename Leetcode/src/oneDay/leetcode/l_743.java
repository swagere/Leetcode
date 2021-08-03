package oneDay.leetcode;

import java.util.Arrays;

//深度优先
public class l_743 {
	static int step = 0;
	public static int networkDelayTime(int[][] times, int n, int k) {
		k--;
		int[][] point = new int[n][n];
        for (int[] item : times) {
        	point[item[0] - 1][item[1] - 1] = item[2];
//        	point[item[1] - 1][item[0] - 1] = item[2];
        }
        
        //深度优先遍历
        int[] isVisited = new int[n];
        int res = dfs(point, k, isVisited);
        
        //输出
        for (int[] item : point) {
        	System.out.println(Arrays.toString(item));
        }
        
        //输出
        System.out.println();
        System.out.println(Arrays.toString(isVisited));
        
        for (int i : isVisited) {
        	if (i == 0) {
        		return -1;
        	}
        }
        
		return res;
    }

	//DFS
	private static int dfs(int[][] point, int k, int[] isVisited) {
		for (int i = 0; i < point[k].length;i++) {
			int index = getNeighbor(point, k, i);
			if (index == -1) {
				break;
			}
			else {
				if (isVisited[index] == 0) { //如果没有被访问过
					isVisited[index] = 1;
					step += point[k][index];
					dfs(point, index, isVisited);
					break;
				}
			}
			
		}
		return 0;
	}
	
	public static int getNeighbor(int[][] point, int k, int start) {
		for (int i = start; i < point[k].length; i++) {
			if (point[k][i] > 0) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
//		int[][] times = {{1,2,1}};
		int n = 4;
		int k = 2;
		System.out.println(networkDelayTime(times, n, k));
	}

}
