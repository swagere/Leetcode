package real.m4_9_mt;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		System.out.println(getCircleCount(num));

	}
	
	public static int getCircleCount(int num) {
		int[] n = {1,0,0,0,0,0,1,0,2,1};
		int count = 0;
		while (num > 9) {
			count += n[num % 10];
			num = (num - num % 10) / 10;
		}
		count += n[num % 10];
		return count;
	}

}
