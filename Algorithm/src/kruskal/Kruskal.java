package kruskal;

import java.util.Arrays;

public class Kruskal {
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) {
		//�������
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
		
		//�Ȼ�ñ�����
		Edge[] edges = getEdges(graph);
		
		//�ٸ��ݱ߽�������
		sortEdges(edges);
		System.out.println(Arrays.toString(edges));
		System.out.println(edges.length);
		
		
		//��С�������α������ж��Ƿ񹹳ɻ�·�����û�й��ɻ�·�������ѡ����
		//�жϹ��ɻ�·���ýڵ���յ��ϼ��
		Edge[] seleted = new Edge[edges.length]; //�������ѡ�����ı�
		int index = 0;
		int[] ends = new int[vertexNum]; // �յ�����
		for (int i = 0; i < edges.length; i++) {
			Edge cur = edges[i];
			int m = getEnd(getIndex(graph, cur.start), ends);
			int n = getEnd(getIndex(graph, cur.end), ends);
			if (m != n) {
				ends[m] = n; //endsû��ֱ�Ӵ��յ㣬���������������±�Ϊ0�ĵ��ҵ��յ�
				seleted[index] = cur;
				index ++;
			}
		}
		
		for (int i = 0; i < index; i++) {
			System.out.println(seleted[i]);
		}
		System.out.println(index);
	}

	//����±�
	private static int getIndex(Graph graph, char index) {
		char[] vertexs = graph.vertexs;
		for (int i = 0; i < vertexs.length; i++) {
			if (vertexs[i] == index) {
				return i;
			}
		}
		return -1;
	}

	//����յ�ڵ�
	private static int getEnd(int i, int[] ends) {
		while (ends[i] != 0) {
			i = ends[i];
		}
		
		// ����ǵ�һ���ڵ���ߺ������ڵ㲻�����ӵĽڵ�  ends[i]��Ϊ�䱾�� 
		// �����ҵ��յ�ڵ�
		return i; 
	}

	//�Ա�����
	private static void sortEdges(Edge[] edges) {
		//ֱ�ӵ��÷���
		Arrays.sort(edges);
		
	}

	//��ȡ������
	private static Edge[] getEdges(Graph graph) {
		int[][] weight = graph.weight;
		int vertexNum = graph.vertexNum;
		char[] vertexs = graph.vertexs;
		int edgeNum = graph.getEdgeNum();
		
		Edge[] edges = new Edge[edgeNum];
		int index = 0;
		for (int i = 0; i < vertexNum; i++) {
			for (int j = i + 1; j < vertexNum; j++) { //��i + 1��ʼ�� �����ظ���
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
