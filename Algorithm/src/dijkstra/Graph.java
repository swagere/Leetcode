package dijkstra;

public class Graph {
	char[] vertexs;
	int vertexNum;
	int[][] weight;
	
	public Graph(char[] vertexs, int vertexNum, int[][] weight) {
		this.vertexs = vertexs;
		this.vertexNum = vertexNum;
		this.weight = weight;
	}
}
