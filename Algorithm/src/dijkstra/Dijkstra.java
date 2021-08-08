package dijkstra;

import java.util.Arrays;

public class Dijkstra {
	static int[] visited;
	static int[] dis;
	static int[] pre; //pre可以不要

	static final int N = 65535;
	
	public static void main(String[] args) {
		char[] vertexs = {'A','B','C','D','E','F','G'};
		int vertexNum = vertexs.length;
		
		int[][] weight = {
				{N,5,7,N,N,N,2},
				{5,N,N,9,N,N,3},
				{7,N,N,N,8,N,N},
				{N,9,N,N,N,4,N},
				{N,N,8,N,N,5,4},
				{N,N,N,4,5,N,6},
				{2,3,N,N,4,6,N}
		};
		
//		Graph graph = new Graph(vertexs, vertexNum, weight);
		
		int index = 2; // 以G点为起点 寻找到各个点的最短路径

		//初始化三个数组
		visited = new int[vertexNum];
		dis = new int[vertexNum];
		Arrays.fill(dis, N);
		dis[index] = 0;
		pre = new int[vertexNum];
		
		while (index != -1) {
			dijkstra(index, weight);
			index = getNextIndex(vertexNum);
		}
		
		System.out.println(Arrays.toString(visited));
		System.out.println(Arrays.toString(dis));
		System.out.println(Arrays.toString(pre));
	}

	//dijkstra算法
	private static void dijkstra(int index, int[][] weight) {
		//将这个点标记为已选择
		visited[index] = 1;
		
		
		//找出和这个点相邻的点 判断距离并更新
		for (int i = 0; i < weight[index].length; i++) {
			if (weight[index][i] < N) {
				//如果是通路
				if (weight[index][i] + dis[index] < dis[i]) {
					dis[i] = weight[index][i] + dis[index];
					pre[i] = index;
				}
			}
		}
		
	}

	//获得下一个当前节点
	public static int getNextIndex(int vertexNum) {
		int min = N;
		int index = -1;
		for (int i = 0; i < vertexNum; i++) {
			//在所有成为当前节点过的节点中找 距离最小的节点
			if (visited[i] == 0 && min > dis[i]) {
				min = dis[i];
				index = i;
			}
		}
		
		return index;
	}
}
