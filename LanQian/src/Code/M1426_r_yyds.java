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
		
		Map<String, Integer> memory = new HashMap<String, Integer>(); //�����Ѿ��߹�������
		Queue<String> queue = new LinkedList<String>();
		int res = -1;
		
		int[] dirX = {-1, 1, 0, 0}; //�� �� �� ��
		int[] dirY = {0, 0, -1, 1};
		
		memory.put(begin, 0); // ��ʼ״̬����
		queue.add(begin); //��ʼ״̬�����
		
		while(res == -1) {  //���û���ҵ����
			String cur = queue.poll(); //����Ԫ�س�����
			
			//���û���ҵ����������
			int pre_x = 0;
			int pre_y = 0;
			for (int i = 0; i < 3; i++) { //���ҵ�.��λ��
				for (int j = 0; j < 3; j++) {
					if (cur.charAt(i * 3 + j) == '.') {
						pre_x = i;
						pre_y = j;
					}
				}
			}
			
			for (int k = 0; k < 4; k++) { //��������Ѱ
				int now_x = pre_x + dirX[k];
				int now_y = pre_y + dirY[k];
				
				if (now_x >= 0 && now_x < 3 && now_y >= 0 && now_y < 3) { //���û������Խ��
					String now = swap(cur, now_x, now_y, pre_x, pre_y);//�õ��µĽ�������ַ���
					

					if (now.equals(end)) { //����ҵ���
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
