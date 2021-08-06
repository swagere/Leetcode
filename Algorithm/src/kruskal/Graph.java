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
	
	//���ͼ�бߵĸ���
	public int getEdgeNum() {
		int count = 0;
		for (int i = 0; i < vertexNum; i++) {
			for (int j = i + 1; j < vertexNum; j++) { //��i + 1��ʼ�� �����ظ���
				if (weight[i][j] != INF) {
					count++;
				}
			}
		}
		
		return count;
	}
}
