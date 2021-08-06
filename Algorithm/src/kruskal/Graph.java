package kruskal;

import java.util.Arrays;

public class Graph {
	static final int INF = Integer.MAX_VALUE;
	
	char[] vertexs;
	int vertexNum;
	int[][] weight;
	
	public Graph(char[] vertexs, int vertexNum, int[][] weight) {
		this.vertexs = Arrays.copyOf(vertexs, vertexNum);
		this.vertexNum = vertexNum;
		this.weight = Arrays.copyOf(weight, vertexNum);
	}
	
	//获得图中边的个数
	public int getEdgeNum() {
		int count = 0;
		for (int i = 0; i < vertexNum; i++) {
			for (int j = i + 1; j < vertexNum; j++) { //从i + 1开始算 不算重复边
				if (weight[i][j] != INF) {
					count++;
				}
			}
		}
		
		return count;
	}
}
