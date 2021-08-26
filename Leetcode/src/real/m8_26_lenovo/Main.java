package real.m8_26_lenovo;

import java.util.Arrays;
import java.util.Scanner;

//kmp
//67%
public class Main {
	public static void solution(String pattern, String s) {
		
		//kmp算法
		//1. 先得出辅助数组
		int n = pattern.length();
		int[] help = new int[n];
		help[0] = 0;
		int i = 1;
		int j = 0;
		while (i < n) {
			while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = help[j - 1];
			}
			
			if (pattern.charAt(i) == pattern.charAt(j)) {
				j++;
			}
			
			help[i] = j;
			i++;
		}
		System.out.println(Arrays.toString(help));
		
		//2. 得出结论
		i = 0;
		j = 0;
		while (i < s.length()) {
			
			while (j > 0 && s.charAt(i) != pattern.charAt(j)) {
				j = help[j - 1];
				System.out.println(j);
			}

			if (s.charAt(i) == pattern.charAt(j)) {
				System.out.println(j);
				j++;
			}
			
			if (j == pattern.length()) {
				System.out.println("Found at: " + (i - j + 1));
				return;
			}
			
			i++;
		}
		
		System.out.println("Not found");
	}

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
        String pattern = cin.nextLine();
        String s = cin.nextLine();
        solution(pattern, s);
	}

}
