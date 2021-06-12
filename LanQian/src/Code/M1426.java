package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.ws.ServiceMode;

public class M1426 {
	public static int[][] swap(int[][] table, int now_x, int now_y, int pre_x, int pre_y) {
		int[][] t = new int[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				t[i][j] = table[i][j];
			}
		}

		int temp = t[pre_x][pre_y];
		t[pre_x][pre_y] = t[now_x][now_y];
		t[now_x][now_y] = temp;
		
		return t;
	}
	
	public class Point {
		int x;
		int y;
		int step;
		
		int[][] recent = new int[3][3];

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getStep() {
			return step;
		}

		public int[][] getRecent() {
			return recent;
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setStep(int step) {
			this.step = step;
		}

		public void setRecent(int[][] recent) {
			this.recent = recent;
		}
		
		
	}

	public static void main(String[] args) {
		//--输入----------------------------------------
		Scanner scanner = new Scanner(System.in);
		String str1 = scanner.nextLine();
		String str2 = scanner.nextLine();
		int[][] input = new int[3][3];
		int[][] output = new int[3][3];
		int start_x = 0, start_y = 0;
		int end_x = 0, end_y = 0;
//		int v[][] = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
//				v[i][j] = 0;
				input[i][j] = (int)str1.charAt(i * 3 + j) - 48;
				output[i][j] = (int)str2.charAt(i * 3 + j) - 48;
				if (str1.charAt(i * 3 + j) == '.') {
					start_x = i;
					start_y = j;
				}
				if (str2.charAt(i * 3 + j) == '.') {
					end_x = i;
					end_y = j;
				}
				
				
			}
		}
		
		//--BFS-----------------------------
		
		int[] dir_x = new int[]{0, 0, 1, -1}; //左 右 下 上
		int[] dir_y = new int[]{-1, 1, 0, 0};
		
		//初始化
		
		List<Point> queue = new ArrayList<Point>();

		Point start = new M1426().new Point();
		start.x = start_x;
		start.y = start_y;
		start.step = 0;
		start.recent = input;
//		v[start.x][start.y] = 1;
		queue.add(start);
		
		int flag = 0;
		int count = 0;
		
		while (!queue.isEmpty()) {
			Point p = queue.get(0);
			
			//如果等于最后的值
			count = 0;
			for (int k = 0; k < 3; k++) {
				for (int j = 0; j < 3; j++) {
					if (p.recent[k][j] == output[k][j])
					count++;
				}
				
			}
			if (count == 9) {
				flag = 1;
				break;
			}
			
			//如果不是则移动方块
			for (int i = 0; i < 4; i++) {
				int x = p.x + dir_x[i];
				int y = p.y + dir_y[i];
				
				if (x >= 3 || y >= 3 || x < 0 || y < 0) {
					continue;
				}
				else {
					
					Point temp = new M1426().new Point();
					temp.setStep(p.step + 1);
					temp.setX(x);
					temp.setY(y);
					temp.setRecent(swap(p.getRecent(), x, y, p.x, p.y));

//					for (int k = 0; k < 3; k++) {
//						for (int j = 0; j < 3; j++) {
//							System.out.print(temp.getRecent()[k][j]);
//						}
//						System.out.println();
//					}
//					System.out.println("\n");
					
					
					queue.add(temp);
//					v[x][y] = 1;
				}
			}
			
			//移除队首元素
			queue.remove(0);
		}
		
		if (flag == 1) {
			System.out.println(queue.get(0).step);
		}
		else {
			System.out.println(0);
		}
	}

}
