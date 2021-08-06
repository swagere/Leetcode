package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//dfs
//三色法
public class l_802_2 {
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int vertexNum = graph.length;
		int[] color = new int[vertexNum];
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < vertexNum; i++) {
			
			if(dfs(graph, i, color)) {
				res.add(i);
			}
		}
		
		return res;
    }
	
	//dfs
	public static boolean dfs(int[][] graph, int index, int[] color) {
		//没有被访问时，先把自己标记为灰色
		if (color[index] == 2) {
			return true;
		}
		else if (color[index] == 1) {
			return false;
		}
		
		color[index] = 1;
		
		for (int i = 0; i < graph[index].length; i++) {
			if(!dfs(graph, graph[index][i], color)) {
				color[index] = 1;
				return false;
			}
		}	
		//必须到最后没有可能成环是才赋值为2
		color[index] = 2;
		return true;
	}
	
	public static void main(String[] args) {
		int[][] graph = {
//				{1,2,3,4},{1,2,3,4},{3,4},{4},{}
				{1,2},{2,3},{5},{0},{5},{},{}
//				{1,2,3,4},{1,2},{3,4},{0,4},{}
				};
		
		
		System.out.println(eventualSafeNodes(graph));
	}

}
