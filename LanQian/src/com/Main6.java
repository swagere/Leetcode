package com;

import java.util.Scanner;

public class Main6 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] years = new int[5];
		int n = 0;
		for (int i = 0; i < 5; i++) {
			years[i] = in.nextInt();
		}
		
		for (int i = 0; i < 5; i++) {
			int year = years[i];
			int[] number = new int[4];
			int count = 0;
			while (year > 10) {
				number[count] = year % 10;
				year = (year - (number[count])) / 10;
				count++;
			}
			number[count] = year;
			if (number[1] == number[3] && number[0] == number[2] + 1) {
				n++;
			}
		}
		System.out.println(n);
	}

}
