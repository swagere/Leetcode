package recursion;

//�Թ�����
//�ݹ���
//��bf
public class maze_1 {

	public static void main(String[] args) {
		//��ʼ����ͼ
		//0Ϊδ�ߵ�·
		//1Ϊǽ
		//2Ϊ�����ߵ�·
		//3Ϊ�߲�ͨ��·
		int[][] map = new int[8][7];
		
		//����ǽ
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
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
		recursion(map, 1, 1);
		
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
	private static boolean recursion(int[][] map, int i, int j) {
		if (map[6][5] == 2) {
			//����ߵ��յ㣬�򷵻�
			return true;
		}
		else {
			if (map[i][j] == 0) {
				map[i][j] = 2;
				if (recursion(map, i, j + 1)) { //��
					
					return true;
				}
				else if (recursion(map, i + 1, j)) { //��

					return true;
				}
				else if (recursion(map, i, j - 1)) { //��
	
					return true;
				}
				else if (recursion(map, i - 1, j)) { //��
	
					return true;
				}
				else {
					map[i][j] = 3;
					return false;
				}
			}
			else {
				return false;
			}
		}
	}

}
