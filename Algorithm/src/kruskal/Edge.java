package kruskal;

public class Edge implements Comparable<Edge>{
	char start;
	char end;
	int value;
	
	public Edge(char start, char end, int value) {
		this.start = start;
		this.end = end;
		this.value = value;
	}

	@Override
	public String toString() {
		return "[<" + start + ", " + end + "> = " + value + "]";
	}

	@Override
	public int compareTo(Edge o) {
		return this.value - o.value;
	}
	
	
}
