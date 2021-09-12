package real.m9_12_aqy;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		
		System.out.println(getRemoveCount(str));
	}

	private static int getRemoveCount(String str) {
		str = str.replace(" ", "");
		str = str.replace("[", "");
		str = str.replace("]", "");
		String[] strList = str.split(",");
		int[][] val = new int[strList.length / 2][2];
		
		int i = 0;
		int j = 0;
		while (i < strList.length) {
			val[j][0] = strList[i].charAt(0) - '0';
			i++;
			val[j][1] = strList[i].charAt(0) - '0';
			i++;
			j++;
		}

		Arrays.sort(val, (a,b)->a[0] - b[0]);
		int res = 0;
		int n = val.length;
		if (n == 0) {
			return res;
		}
		
		int[] cur = val[0];
		for (i = 1; i < n; i++) {
			if (val[i][0] < cur[1]) {
				res += 1;
				
				//保留较小的区间
				cur[1] = Math.min(val[i][1], cur[1]);
			}
			else {
				cur = val[i];
			}
		}
		return res;
	}

}
