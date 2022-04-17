package real.m4_16_360;


import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int n = in.nextInt();
//		int[] h = new int[n];
//		for (int i = 0; i < n; i++) {
//			h[i] = in.nextInt();
//		}
		int[] h = {1,2,5,5,5,1};
		System.out.println(getCount(h));
	}
	
	public static int getCount(int[] h) {
		int max = h[0];
		int index = -1;
		for (int i = 1; i < h.length; i++) {
			if (max < h[i]) {
				max = h[i];
				index = i;
			}
		}
		
		
		int res = index == 0 ? 0 : index + 1;
		for (int i = 0; i < h.length; i++) {
			if (max == h[i]) {
				res = Math.max(res, i - index);
				index = i;
			}
		}
		res = Math.max(res, h.length - index);
		
		return res == 0? res : res - 1;
	}

}
