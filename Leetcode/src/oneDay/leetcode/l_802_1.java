package oneDay.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//w
//��ʱ
//�ҵ�ѭ����· Ȼ���ټ���
//bfs
public class l_802_1 {
	static List<Integer> right = new ArrayList<>();
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		int vertexNum = graph.length;
		
		for (Integer i = 0; i < vertexNum; i++) {
			right.add(i);
		}
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		//ѭ������ÿ����
		for (Integer i = 0; i < vertexNum; i++) {
			List<Integer> temp = bfs(graph, i);
			if (temp == null) {
				right.remove(i);
			}
			else {
				map.put(i, temp);
				
			}
			
		}
		
		for (Integer i : map.keySet()) {
			for (Integer j : map.get(i)) {
				if (!right.contains(j)) {
					right.remove(i);
					break;
				}
			}
		}
		
		return right;
    }
	
	//���ѵ��Լ�
	public static List<Integer> bfs(int[][] graph, int index) { 
		List<Integer> res = new ArrayList<>();
		res.add(index);
		int count = 0;
		
		while (count < res.size()) {
			int temp = res.get(count);
			count++;
			for (int i = 0; i < graph[temp].length; i++) {
				int next = graph[temp][i];
				if (!res.contains(next)) {
					if (!right.contains(next)) {
						return null;
					}
					res.add(next);
				}
				else if (next == index) {
					//˵����һ��ѭ�� ��ʱ����ѭ��
					return null;
				}
			}
			
		}
		
		return res;
	}
	
	
	public static void main(String[] args) {
		int[][] graph = {
				{1,2,3,4},{1,2,3,4},{3,4},{4},{}
				};
		
		
		System.out.println(eventualSafeNodes(graph));
	}

}
