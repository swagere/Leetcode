package floyd;

public class FloydDemo {

	static final int N = 65535;
	
	public static void main(String[] args) {
		char[] vertexs = {'A','B','C','D','E','F','G'};
		int vertexNum = vertexs.length;
		
		
		int[][] dis = {
				{0,5,7,N,N,N,2},
				{5,0,N,9,N,N,3},
				{7,N,0,N,8,N,N},
				{N,9,N,0,N,4,N},
				{N,N,8,N,0,5,4},
				{N,N,N,4,5,0,6},
				{2,3,N,N,4,6,N}
		};

		Graph graph = new Graph(vertexs, vertexNum, dis);
		graph.show();
		
		graph.floyd();
		graph.show();
	}

}
