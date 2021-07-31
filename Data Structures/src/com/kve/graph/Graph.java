package com.kve.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	List<String> vertexList;
	int[][] edges;
	int numOfEdges;
	
	int[] isVisited;
	
	public Graph(int n) {
		this.numOfEdges = n;
		vertexList = new ArrayList<>(n);
		edges = new int[n][n];
		
		isVisited = new int[n];
	}
	
	//添加顶点
	public void addVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//建立图对应的邻接矩阵
	public void addEdges(String a, String b, int value) {
		int i = vertexList.indexOf(a);
		int j = vertexList.indexOf(b);
		edges[i][j] = value;
		edges[j][i] = value;
	}
	
	//输出邻接矩阵
	public void showEdges() {
		for (int[] item : edges) {
			System.out.println(Arrays.toString(item));
		}
	}
	
	//-- 深度优先搜索 DFS --
	//DFS 重载
	public void dfs() {
		for (int i = 0; i < numOfEdges; i++) {
			if (isVisited[i] == 0) {
				dfs(i);
			}
		}
	}

	public void dfs(int index) {
		//先输出自己 标记自己已经被访问
		System.out.print(vertexList.get(index) + " ");
		isVisited[index] = 1;
//		System.out.println(Arrays.toString(isVisited));
		
		
		//找到数组中第一个不为0的
		int start = getNeighbor(index, 0);
		
		while (start != -1){
			if (isVisited[start] == 0) {
				dfs(start);
				break;
			}
			
			
			start = getNeighbor(index, start + 1);
		}
	}
	
	/**
	 * 
	 * @param index 第几行
	 * @param start 从哪个开始
	 * @return 从start开始的第一个邻接节点
	 */
	public int getNeighbor(int index, int start) {
		for (int i = start; i < numOfEdges; i++) {
			if (edges[index][i] == 1) {
				return i;
			}
		}
		
		return -1;
	}
	
	//-- 广度优先搜索 BFS --
	public void bfs() {
		for (int i = 0; i < numOfEdges; i++) {
			if (isVisited[i] == 0) {
				LinkedList<Integer> queue = new LinkedList<>();
				bfs(i, queue);
			}
		}
	}
	
	public void bfs(int index, LinkedList<Integer> queue) {
		System.out.print(vertexList.get(index) + " ");
		isVisited[index] = 1;
		queue.addLast(index);
		
		
		while (!queue.isEmpty()) {
			index = queue.removeFirst();
			
			//找到队列中第一个不为0的
			int start = getNeighbor(index, 0);
			while (start != -1) {
				if (isVisited[start] == 0) {
					//加入队列
					System.out.print(vertexList.get(start) + " ");
					isVisited[start] = 1;
					queue.addLast(start);
				}
				
				start = getNeighbor(index, start + 1);
			}
			
			
		}
		
		
	}
}
