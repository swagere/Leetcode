package oneDay.leetcode;

import java.util.LinkedList;

public class l_847_1 {
	static LinkedList<Integer> aims = new LinkedList<Integer>();
	public static int shortestPathLength(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			aims.add(i);
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < graph.length; i++) {
			int res = bfs(graph, i);
			if (res < min) {
				min = res;
			}
		}
		
		return min - 1;
    }
	
	public static int bfs(int[][] graph, int index) {
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(index);
		int count = 0;
		
		while (queue.size() > 0) {
			int temp = queue.removeFirst();
			count++;
			for (int i = 0; i < graph[temp].length; i++) {
				queue.add(graph[temp][i]);
				
				if (queue.containsAll(aims)) {
//					System.out.println(queue);
					return count;
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		int[][] graph = {
				{1,2,3},{0},{0},{0}	
//				{1},{0,2,4},{1,3,4},{2},{1,2,}
		};

		System.out.println(shortestPathLength(graph));
	}

}
