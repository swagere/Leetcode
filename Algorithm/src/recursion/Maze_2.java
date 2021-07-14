package recursion;

import java.util.ArrayList;
import java.util.List;

//�Թ�����
//ֻ���ҵ���̾���
//bfs bfsΪwhile���
public class Maze_2 {

	public static void main(String[] args) {
		//��ʼ����ͼ
		//0Ϊδ�ߵ�·
		//1Ϊǽ �����ߵ�·
		int[][] map = new int[8][7];
		
		//����ǽ
//		for (int i = 0; i < 7; i++) {
//			map[0][i] = 1;
//			map[7][i] = 1;
//		}
//		for (int i = 0; i < 8; i++) {
//			map[i][0] = 1;
//			map[i][6] = 1;
//		}
		map[3][1] = 1;
		map[3][2] = 1;
		map[6][4] = 1;
		map[1][5] = 1;
		map[2][5] = 1;
		map[2][4] = 1;

		//��ʾ
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//���Թ�
		recursion(map);
		
		//��ʾ
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 7; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	//i jΪĿǰ��ʼ�ĵ�
	//�ݹ�˳���� �� �� ��
	private static void recursion(int[][] map) {
		int start_x = 1;
		int start_y = 1;
		List<Node> list = new ArrayList<>();
		map[start_x][start_y] = 1;
		
		//�� �� �� ��
		int[] way_x = {0, 1, 0, -1};
		int[] way_y = {1, 0, -1, 0};
		
		//�ȴ�����ʼ��
		list.add(new Node(start_x, start_y, 1));
		while (!list.isEmpty()) {
			Node cur = list.remove(0);
			int x = cur.x;
			int y = cur.y;
			int value = cur.value;
			if (x == 6 && y == 5) {
				System.out.println(value);
				System.out.println();
				break;
			}
			for (int i = 0; i < 4; i++) {
				int xx = x + way_x[i];
				int yy = y + way_y[i];
				if (xx < 8 && yy < 7 && xx >= 0 && yy >= 0) {
					if (map[xx][yy] != 1) {
						list.add(new Node(xx, yy, value+1));
					}
					map[xx][yy] = 1;
				}
			}
		}
	}

}

class Node {
	int x;
	int y;
	int value;
	
	public Node(int x, int y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}
	
}
