package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//r
public class l_797_2 {
	static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		int n = graph.length;
		dfs(graph, 0, n - 1, new ArrayList<Integer>());
		
		return res;
    }
	

	private static void dfs(int[][] graph, int cur, int dst, List<Integer> list) {
		if (cur == dst) {
			list.add(cur);
			List<Integer> newList = new ArrayList<Integer>();
			newList.addAll(list);
			res.add(newList);
			list.remove((Integer)cur);
			return;
		}
		
		list.add(cur);
		for (int i = 0; i < graph[cur].length; i++) {
			dfs(graph, graph[cur][i], dst, list);
		}
		list.remove((Integer)cur);
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
