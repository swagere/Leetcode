package oneDay.leetcode;

import java.util.LinkedList;

//r
//自己改写
//广搜：一层一层往下走
//走过的路径用压缩数组表示
//增加数组保存mask状态 相同的mask状态则不循环遍历
public class l_847_2 {
	public static int shortestPathLength(int[][] graph) {
		int n = graph.length; //顶点个数
		LinkedList<int[]> queue = new LinkedList<>(); //三元组标识一个节点：节点编号index 走过的路径(int)mask 走过的距离dist
		boolean[][] vis = new boolean[n][1 << n];
		
		//多源广搜
		for (int i = 0; i < graph.length; i++) {
			queue.add(new int[] {i, 1 << i, 0});
			vis[i][1 << i] = true;
		}
		
		while (queue.size() > 0) {
			int[] temp = queue.removeFirst();
			int step = temp[2];
			int index = temp[0];
			for (int i = 0; i < graph[index].length; i++) {
				int newMask = temp[1] | (1 << graph[index][i]);
				if (!vis[graph[index][i]][newMask]) {
					queue.add(new int[] {graph[index][i], newMask, step + 1});
					vis[graph[index][i]][newMask] = true;
					//判断是否已经遍历全部节点
					if (newMask == (1 << n) - 1) {
						return step + 1;
					}
				}
				
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		int[][] graph = {
//				{1,2,3},{0},{0},{0}	
				{1},{0,2,4},{1,3,4},{2},{1,2,}
//				{}
		};

		System.out.println(shortestPathLength(graph));
	}

}
