package com;

import java.util.Scanner;

public class Main7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		long n = in.nextInt();
		long count = 0;
		
		for (long i = 1; i < n; i++) {
			long p = i * i;
			long res = p % n;
			if (res < (double)n/2) {
				count++;
			}
		}
		System.out.println(count);
	}

}
