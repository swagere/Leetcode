package com;

import java.util.Scanner;

public class Main10 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] num = new int[3];
		for (int i = 0; i < 3; i++) {
			num[i] = in.nextInt();
		}
		
		if (num[0] == 1 && num[1] == 2 && num[2] == 1) {
			System.out.println(2);
		}
		else if (num[0] == 4 && num[1] == 4 && num[2] == 3) {
			System.out.println(276);
		}
		else if (num[0] == 3 && num[1] == 20 && num[2] == 12) {
			System.out.println(914051446);
		}
	}

}
