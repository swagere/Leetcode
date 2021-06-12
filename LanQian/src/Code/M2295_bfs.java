package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M2295_bfs {
	public static class Point {
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		public int getStep() {
			return step;
		}
		public void setStep(int step) {
			this.step = step;
		}
		public int getIsWudi() {
			return isWudi;
		}
		public void setIsWudi(int isWudi) {
			this.isWudi = isWudi;
		}
		public int getWudi() {
			return wudi;
		}
		public void setWudi(int wudi) {
			this.wudi = wudi;
		}
		int x;
		int y;
		int step;
		int isWudi = 0;
		int wudi = 0;
	}
	
	
	public static void main(String[] args) {
		//--����---------------------------
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		String[][] a = new String[n][n];
		
//		int[][] v = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			String temp = scanner.next();
			
			for (int j = 0; j < n; j++) {
				a[i][j] = String.valueOf(temp.charAt(j));
//				v[i][j] = 0;
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println("\n");
		}
		
		//--BFS--------------------------
		
		List<Point> queue = new ArrayList<M2295_bfs.Point>();
		int[] dir_x = new int[]{0, 1, 0, -1}; //�� �� �� ��
		int[] dir_y = new int[]{1, 0, -1, 0};
		
		//��ʼ��
		
		Point start = new Point();
		start.x = 0;
		start.y = 0;
		start.step = 0;
//		v[start.x][start.y] = 1;
		queue.add(start); //�������
		int flag = 0;
		
		while (!queue.isEmpty()) {
			Point p = queue.get(0);
			
			//�������Ŀ�ĵ�
			if (p.x == n - 1 && p.y == n - 1) {
				flag = 1;
				break;
			}
			
			//���û�е��Ѱ�ҿ����ߵ�·
			
			
//			v[p.x][p.y] = 1;
			for (int i = 0; i < 4; i++) {
				int x = p.x + dir_x[i];
				int y = p.y + dir_y[i];
				
				if (x >= n || y >= n || x < 0 || y < 0) {
					continue;
				}
				else if ( a[x][y].equals("#")) {
					continue;
				}
				else if (a[x][y].equals(".") || (a[x][y].equals("X") && p.isWudi == 1 || a[x][y].equals("%"))) {
					Point temp = new Point();
					temp.setX(x);
					temp.setY(y);
					temp.setStep(p.step + 1);
					if (a[x][y].equals("%")) {
						a[x][y] = "#"; // �Ż�1��������%�Ͳ�Ҫ�ٴν��룬�����Ч��
						if (p.isWudi == 0) {
							temp.wudi = k;
							temp.isWudi = 1;
						}
						else if (p.isWudi == 1) {
							temp.wudi = 0;
							temp.isWudi = 0;
						}
					}
					else {
						if (p.wudi - 1 <= 0) {
							temp.setIsWudi(0);
							temp.setWudi(0);
						}
						else if (p.wudi - 1 > 0){
							temp.setIsWudi(1);
							temp.setWudi(p.wudi - 1);
						}
					}
					queue.add(temp);
					
				}
			}
			
			
			//������
			queue.remove(p);
		}
		if (flag == 1) {
			System.out.println(queue.get(0).step);
		}
		else {
			System.out.println(0);
		}

	}

}
