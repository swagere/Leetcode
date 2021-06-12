package com;

public class Main4 {

	public static void main(String[] args) {
		int n = 2021;
		int count = 0;
		for (int a = 1; a <= 2021; a++) {
			for (int b = a; b <= 2021; b++) {
				if (a + b < 2021) { 
					for (int c = a; c <= 2021; c++) {
						if (a + b + c < 2021) {
							for (int d = a; d <= 2021; d++) {
								if (a + b + c + d < 2021) {
									for (int e = a; e <= 2021; e++) {
										if (a + b + c + d + e == 2021) {
											count++;
										}
									}
								}
							}
						}
					}
				}
				
			}
		}
		System.out.println(count);
	}

}
