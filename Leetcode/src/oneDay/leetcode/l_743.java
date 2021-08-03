package oneDay.leetcode;

import java.util.Arrays;
import java.util.LinkedList;


//w
//深度优先
public class l_743 {
	public static int networkDelayTime(int[][] times, int n, int k) {
		k -= 1;
		int[][] point = new int[n][n];
        for (int[] item : times) {
        	point[item[0] - 1][item[1] - 1] = item[2]; //有向图
        }
        
        //广度优先遍历搜索
        int[] isVisited = new int[n];
        LinkedList<Integer> queue = new LinkedList<>();
        int res = bfs(point, k, isVisited, queue);
        
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

	//BFS
	//循环实现
	private static int bfs(int[][] point, int k, int[] isVisited, LinkedList<Integer> queue) {
		int step = 0;
		queue.add(k);
		isVisited[k] = 1;
		
		while (!queue.isEmpty()) {
			int max = 0;
			int temp = queue.removeFirst();
			for (int i = 0; i < point[temp].length;i++) {
				int index = getNeighbor(point, temp, i);
				if (index == -1) {
					break;
				}
				else {
					if (isVisited[index] == 0) { //如果没有被访问过
						max = Math.max(max, point[temp][index]);
						isVisited[index] = 1;
						queue.addLast(index);
					}
				}
				
			}
			step += max;
		}
		return step;
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
		int[][] times = {{1,2,1},{2,3,2},{1,3,4}};
		int n = 3;
		int k = 1;
		System.out.println(networkDelayTime(times, n, k));
	}

}
