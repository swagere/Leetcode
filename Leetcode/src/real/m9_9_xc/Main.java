package real.m9_9_xc;

import java.util.Scanner;

public class Main {
	static int max = Integer.MIN_VALUE;
	public static int getMax(int n, int m, int[][] rules, String s) {
		dfs(m, rules, s, 0, 0);
		return max;
	}
	
	public static void dfs(int m, int[][] rules, String s, int grade, int begin) {
		if (begin >= s.length()) {
			return;
		}
		String temp = new String(s);
		for (int i = 0; i < rules.length; i++) {
			boolean flag = true;
			for (int j = 0; j < rules[i][0]; j++) {
				if (temp.length() - 1 < begin + j || temp.charAt(begin + j) != '1') {
					flag = false;
					break;
				}
			}
			if (flag == true) {
				temp = temp.substring(rules[i][0]);
				dfs(m, rules, temp, grade + rules[i][1], begin);
			}
			else {
				dfs(m, rules, temp, grade, begin + 1);
			}
			temp = String.valueOf(s);
			max = Math.max(max, grade);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		in.nextLine();
		String s = in.nextLine();
		int[][] rules = new int[m][2];
		for (int i = 0; i < m; i++) {
			rules[i][0] = in.nextInt();
			rules[i][1] = in.nextInt();
		}
		System.out.println(getMax(n, m, rules, s));
	}

}
