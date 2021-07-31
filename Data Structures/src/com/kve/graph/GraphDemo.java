package com.kve.graph;

public class GraphDemo {

	public static void main(String[] args) {
		int n = 8;
		String[] vertexs = {"1", "2", "3", "4", "5", "6", "7", "8"};
		
		Graph graph = new Graph(n);
		//添加节点
		for (String vertex : vertexs) {
			graph.addVertex(vertex);
		}
		
		//添加边
		graph.addEdges("1", "2", 1);
		graph.addEdges("1", "3", 1);
		graph.addEdges("2", "4", 1);
		graph.addEdges("2", "5", 1);
		graph.addEdges("3", "6", 1);
		graph.addEdges("3", "7", 1);
		graph.addEdges("4", "8", 1);
		graph.addEdges("5", "8", 1);
		graph.addEdges("6", "7", 1);

		//输出邻接矩阵
//		graph.showEdges();
		
		//深度优先搜索DFS
//		graph.dfs();
//		System.out.println();
		
		//广度优先搜索BFS
		graph.bfs();
	}

}
