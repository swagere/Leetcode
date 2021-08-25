package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//r
public class l_797_1 {
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int n = graph.length;
		dfs(graph, 0, n - 1, new ArrayList<Integer>());
		
		return res;
    }
	

	private static void dfs(int[][] graph, int cur, int dst, List<Integer> list) {
		if (cur == dst) {
			List<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			newList.add(cur);
			res.add(newList);
			return;
		}
		
		List<Integer> newList = new ArrayList<Integer>();
		newList.addAll(list);
		newList.add(cur);
		for (int i = 0; i < graph[cur].length; i++) {
			dfs(graph, graph[cur][i], dst, newList);
		}
	}


	public static void main(String[] args) {
		int[][] graph = {
//				{1,2},{3},{3},{}
				{4,3,1},{3,2,4},{3},{4},{}
//				{1,2,3},{2},{3},{}
//				{1,3},{2},{3},{}
		};
		
		System.out.println(allPathsSourceTarget(graph));

	}

}
