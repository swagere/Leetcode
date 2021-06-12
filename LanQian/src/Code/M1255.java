package Code;

import java.util.Scanner;

public class M1255 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] ns = new int[n];
		for (int i = 0; i < n; i++) {
			ns[i] = scanner.nextInt();
		}
		long res = 0;
		while (n >= 2) {
			//得到最小值
			int index = 0;
			int min = ns[0];
			for (int i = 1; i < n; i++) {
				if (ns[i] < min) {
					min = ns[i];
					index = i;
				}
			}
			
			int behind_index = (index - 1 + n)%n;
			int before_index = (index + 1 + n)%n;
			res = res + ns[behind_index]*min*ns[before_index];
			
			
			//去掉最小值
			for (int i = index; i < n - 1; i++) {
				ns[i] = ns[i + 1];
			}
			ns[n - 1] = 0;
			n--;
		}
		System.out.println(res);
		
	}

}
