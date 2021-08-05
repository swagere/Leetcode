package prim;

import java.util.ArrayList;
import java.util.List;

public class Prim {

	public static void main(String[] args) {
		//创建图对象
		char[] vertexs = new char[]{'A','B','C','D','E','F','G'};
		int vertexNum = vertexs.length;
		
		int[][] weight = new int[][] {
			{10000,5,7,10000,10000,10000,2},
			{5,10000,10000,9,10000,10000,3},
			{7,10000,10000,10000,8,10000,10000},
			{10000,9,10000,10000,10000,4,10000},
			{10000,10000,8,10000,10000,5,4},
			{10000,10000,10000,4,5,10000,6},
			{2,3,10000,10000,4,6,10000}
		};
		
		Graph graph = new Graph(vertexNum, vertexs, weight);
		
		prim(graph, 0);
	}

	//prim算法
	private static void prim(Graph graph, int index) {
		List<Integer> selected = new ArrayList<>();
		selected.add(index);
		
		while (selected.size() < graph.vertexNum) {
			int min = 10000;
			int x = -1;
			int y = -1;
			for (Integer i : selected) {
				for (int j = 0; j < graph.vertexNum; j++) {
					if ((!selected.contains(j)) && graph.weight[i][j] < min) {
						min = graph.weight[i][j];
						x = i;
						y = j;
					}
				}
			}
			
			//找出一次最小的
			selected.add(y);
			System.out.println("边<" + graph.vertexs[x] + "," + graph.vertexs[y] + "> 权值:" + min);
		}
		
	}

}
