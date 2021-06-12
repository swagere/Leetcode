package Code;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class M1426_r_yyds {
	public static String swap(String str, int x, int y, int m, int n) {
		char[] chars = str.toCharArray();
		char temp = chars[x * 3 + y];
		chars[x * 3 + y] = chars[m * 3 + n];
		chars[m * 3 + n] = temp;
		return String.copyValueOf(chars);
	}
	
	
	public static int bfs(String begin, String end) {
		
		Map<String, Integer> memory = new HashMap<String, Integer>(); //保存已经走过的数组
		Queue<String> queue = new LinkedList<String>();
		int res = -1;
		
		int[] dirX = {-1, 1, 0, 0}; //上 下 左 右
		int[] dirY = {0, 0, -1, 1};
		
		memory.put(begin, 0); // 初始状态保存
		queue.add(begin); //初始状态入队列
		
		while(res == -1) {  //如果没有找到结果
			String cur = queue.poll(); //队首元素出队列
			
			//如果没有找到则继续遍历
			int pre_x = 0;
			int pre_y = 0;
			for (int i = 0; i < 3; i++) { //先找到.的位置
				for (int j = 0; j < 3; j++) {
					if (cur.charAt(i * 3 + j) == '.') {
						pre_x = i;
						pre_y = j;
					}
				}
			}
			
			for (int k = 0; k < 4; k++) { //在四周搜寻
				int now_x = pre_x + dirX[k];
				int now_y = pre_y + dirY[k];
				
				if (now_x >= 0 && now_x < 3 && now_y >= 0 && now_y < 3) { //如果没有数组越界
					String now = swap(cur, now_x, now_y, pre_x, pre_y);//得到新的交换后的字符串
					

					if (now.equals(end)) { //如果找到了
						res = memory.get(cur) + 1;
					}
					
					if (!memory.containsKey(now)) {
						memory.put(now, memory.get(cur) + 1);
						queue.add(now);
					}
				}
			}

		}
		
		return res;
		
		
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String begin = scanner.next();
		String end = scanner.next();
		
		System.out.println(bfs(begin, end));
	}
}
