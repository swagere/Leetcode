package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M1426_simple {
	public static String swap(String pre, int now_x, int now_y, int pre_x, int pre_y) {
		
		char[] array = pre.toCharArray();
		char temp = array[now_x * 3 + now_y];
		array[now_x * 3 + now_y] = array[pre_x * 3 + pre_y];
		array[pre_x * 3 + pre_y] = temp;
		
	
		return String.copyValueOf(array);
	}
	
	public class Point {
		int x;
		int y;
		int step;
		String recent = new String();
		

		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		public void setStep(int step) {
			this.step = step;
		}
		public void setRecent(String recent) {
			this.recent = recent;
		}
	}

	public static void main(String[] args) {
		//--输入----------------------------------------
		Scanner scanner = new Scanner(System.in);
		String begin = scanner.nextLine();
		String end = scanner.nextLine();
		int start_x = 0, start_y = 0;
		int end_x = 0, end_y = 0;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (begin.charAt(i * 3 + j) == '.') {
					start_x = i;
					start_y = j;
				}
				if (end.charAt(i * 3 + j) == '.') {
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

		Point start = new M1426_simple().new Point();
		start.x = start_x;
		start.y = start_y;
		start.step = 0;
		start.recent = begin;
		queue.add(start);
		
		int flag = 0;
		
		while (!queue.isEmpty()) {
			Point p = queue.get(0);
			
			//如果等于最后的值
			if (p.recent.equals(end)) {
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
					
					Point temp = new M1426_simple().new Point();
					temp.setStep(p.step + 1);
					temp.setX(x);
					temp.setY(y);
					temp.setRecent(swap(p.recent, x, y, p.x, p.y));

//					for (int k = 0; k < 3; k++) {
//						for (int j = 0; j < 3; j++) {
//							System.out.print(temp.getRecent()[k][j]);
//						}
//						System.out.println();
//					}
//					System.out.println("\n");
					
					
					queue.add(temp);
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
