package oneDay.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class l_847_2 {
	public static int shortestPathLength(int[][] graph) {
		int n = graph.length;

        // 1.��ʼ�����м�������飬�������
        Queue<int[]> queue = new LinkedList<int[]>(); // �������Էֱ�Ϊ idx, mask, dist
        boolean[][] vis = new boolean[n][1 << n]; // �ڵ��ż���ǰ״̬
        for (int i = 0; i < n; i++) {
            queue.offer(new int[]{i, 1 << i, 0}); // ������㣬��ʼ����0�����
            vis[i][1 << i] = true;
        }

        // ��ʼ����
        while (!queue.isEmpty()) {
            int[] tuple = queue.poll(); // ������ͷԪ��
            int idx = tuple[0], mask = tuple[1], dist = tuple[2];

            // �ҵ��𰸣����ؽ��
            if (mask == (1 << n) - 1) return dist;
            
            // ��չ
            for (int x : graph[idx]) {
                int next_mask = mask | (1 << x);
                if (!vis[x][next_mask]) {
                    queue.offer(new int[]{x, next_mask, dist + 1});
                    vis[x][next_mask] = true;
                }
            }
        }
        return 0;
	}

	public static void main(String[] args) {
		int[][] graph = {
				{1,2,3},{0},{0},{0}	
//				{1},{0,2,4},{1,3,4},{2},{1,2,}
		};

		System.out.println(shortestPathLength(graph));
	}

}
