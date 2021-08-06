package kruskal;

import java.util.Arrays;

public class Kruskal {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		//输入参数
		char[] vertexs = {'A','B','C','D','E','F','G'};	
		int vertexNum = vertexs.length;
		int[][] weight = {
				{0,12,INF,INF,INF,16,14},
				{12,0,10,INF,INF,7,INF},
				{INF,10,0,3,5,6,INF},
				{INF,INF,3,0,4,INF,INF},
				{INF,INF,5,4,0,2,8},
				{16,7,6,INF,2,0,9},
				{14,INF,INF,INF,8,9,0}
		};
		
		Graph graph = new Graph(vertexs, vertexNum, weight);
		
		//先获得边数组
		Edge[] edges = getEdges(graph);
		
		//再根据边进行排序
		sortEdges(edges);
		System.out.println(Arrays.toString(edges));
		System.out.println(edges.length);
		
		
		//从小到大依次遍历，判断是否构成环路，如果没有构成环路则加入已选集合
		//判断构成环路：用节点的终点结合检测
		Edge[] seleted = new Edge[edges.length]; //最后结果所选出来的边
		int index = 0;
		int[] ends = new int[vertexNum]; // 终点数组
		for (int i = 0; i < edges.length; i++) {
			Edge cur = edges[i];
			int m = getEnd(getIndex(graph, cur.start), ends);
			int n = getEnd(getIndex(graph, cur.end), ends);
			if (m != n) {
				ends[m] = n; //ends没有直接存终点，而是依靠遍历到下标为0的点找到终点
				seleted[index] = cur;
				index ++;
			}
		}
		
		for (int i = 0; i < index; i++) {
			System.out.println(seleted[i]);
		}
		System.out.println(index);
	}

	//获得下标
	private static int getIndex(Graph graph, char index) {
		char[] vertexs = graph.vertexs;
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i] == index) {
				return i;
			}
		}
		return -1;
	}

	//获得终点节点
	private static int getEnd(int i, int[] ends) {
		while (ends[i] != 0) {
			i = ends[i];
		}
		
		// 如果是第一个节点或者和其他节点不能连接的节点  ends[i]都为其本身 
		// 可以找到终点节点
		return i; 
	}

	//对边排序
	private static void sortEdges(Edge[] edges) {
		//直接调用方法
		Arrays.sort(edges);
		
	}

	//获取边数组
	private static Edge[] getEdges(Graph graph) {
		int[][] weight = graph.weight;
		int vertexNum = graph.vertexNum;
		char[] vertexs = graph.vertexs;
		int edgeNum = graph.getEdgeNum();
		
		Edge[] edges = new Edge[edgeNum];
		int index = 0;
		for (int i = 0; i < vertexNum; i++) {
			for (int j = i + 1; j < vertexNum; j++) { //从i + 1开始算 不算重复边
				if (weight[i][j] != INF) {
					Edge edge = new Edge(vertexs[i], vertexs[j], weight[i][j]);
					edges[index] = edge;
					index++;
				}
			}
		}
		
		return edges;
	}

}
