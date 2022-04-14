package real.m4_14_blf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
4
1 1
2 3
2 3
1 1
1 1
1 1
1 2
 *
 */
public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int width = in.nextInt();
		in.nextLine();
		List<String> input = new ArrayList<String>();
		while (in.hasNext()) {
			input.add(in.nextLine());
		}
		int[][] item = new int[input.size()][2];
		for (int i = 0; i < input.size(); i++) {
			String[] temp = input.get(i).split(" ");
			item[i][0] = Integer.valueOf(temp[0]);
			item[i][1] = Integer.valueOf(temp[1]);
		}
//		int[][] item = {
//				{1,1},
//				{2,3},
//				{2,3},
//				{1,1},
//				{1,1},
//				{1,1},
//				{1,2}
//		};
		putItem(width, item, 0, 0, 0, 0, 0);
		System.out.println(min);
	}
	
	
	static int min = Integer.MAX_VALUE;
	public static void putItem(int width, int[][] item, int index, int cur_w, int cur_h, int height, int floor) {
		if (index == item.length) {
			height += cur_h;
			min = Math.min(min, height);
			return;
		}
		
		//判断是否可以放在当前层
		if (cur_w + item[index][0] <= width) {
			//放在当前层
//			cur_h = ;
			putItem(width, item, index + 1, cur_w + item[index][0], Math.max(cur_h, item[index][1]), height, 0);
		}
		
		//放在下一层
		putItem(width, item, index + 1, item[index][0], item[index][1], height + cur_h, 1);
	}

}
