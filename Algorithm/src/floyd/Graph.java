package floyd;

import java.util.Arrays;

public class Graph {
	char[] vertexs;
	int vertexNum;
	int[][] dis;
	int[][] pre;
	
	//构造方法
	public Graph(char[] vertexs,int vertexNum, int[][] dis) {
		this.vertexs = vertexs;
		this.vertexNum = vertexNum;
		this.dis = dis;
		
		pre = new int[vertexNum][vertexNum];
		for (int i = 0; i < vertexNum; i++) {
			Arrays.fill(pre[i], i);
		}
	}
	
	//显示
	public void show() {
		for (int i = 0; i < vertexNum; i++) {
			System.out.println(Arrays.toString(dis[i]));
		}
		
		System.out.println();
		
		for (int i = 0; i < vertexNum; i++) {
			for (int j = 0; j < this.vertexNum; j++) {
				System.out.print(vertexs[pre[i][j]] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	//floyd算法
	public void floyd() {
		for (int k = 0 ; k < this.vertexNum; k++) {
			for (int i = 0; i < this.vertexNum; i++) {
				for (int j = 0; j < this.vertexNum; j++) {
					if (dis[i][k] + dis[k][j] < dis[i][j]) {
						dis[i][j] = dis[i][k] + dis[k][j];
						pre[i][j] = pre[k][j];
					}
				}
			}
		}
		
	}
}
