package oneDay.leetcode;

import java.util.LinkedList;

//r
//�Լ���д
//���ѣ�һ��һ��������
//�߹���·����ѹ�������ʾ
//�������鱣��mask״̬ ��ͬ��mask״̬��ѭ������
public class l_847_2 {
	public static int shortestPathLength(int[][] graph) {
		int n = graph.length; //�������
		LinkedList<int[]> queue = new LinkedList<>(); //��Ԫ���ʶһ���ڵ㣺�ڵ���index �߹���·��(int)mask �߹��ľ���dist
		boolean[][] vis = new boolean[n][1 << n];
		
		//��Դ����
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
					//�ж��Ƿ��Ѿ�����ȫ���ڵ�
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
