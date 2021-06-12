package com;

import java.util.Scanner;

public class Main8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		long count = 0;
		long index = n;
		
		for (long i = 1; i <= n; i++) {
			long c = n * i;
			if (Math.sqrt(c) % 1 <= 0.00000000000000001) { //平方数是否为整数
				index = i;
				break;
			}
		}
		System.out.println(index);
	}

}
