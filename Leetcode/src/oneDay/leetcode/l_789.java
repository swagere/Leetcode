package oneDay.leetcode;

import java.util.LinkedList;

//模拟
public class l_789 {
	public static boolean escapeGhosts(int[][] ghosts, int[] target) {
		int step = Math.abs(target[0]) + Math.abs(target[1]);
		for (int[] item : ghosts) {
			int temp = Math.abs(target[0] - item[0]) + Math.abs(target[1] - item[1]);
			if (temp <= step) {
				return false;
			}
		}
		return true;
    }

	public static void main(String[] args) {
		int[][] ghosts = {
				{1,0},{0,3}
		};
		int[] target = {0,1};
		System.out.println(escapeGhosts(ghosts, target));

	}

}
