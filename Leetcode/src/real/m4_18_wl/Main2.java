package real.m4_18_wl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		System.out.println(getCount(str));
	}

	//·ÖÖÎ·¨
	public static List<Integer> getCount(String str) {
		List<Integer> r = new ArrayList<>();
		if (str.length() <= 2) {
			r.add(Integer.valueOf(str));
		}
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '+' || c == '-' || c == '*') {
				List<Integer> left = getCount(str.substring(0, i));
				List<Integer> right = getCount(str.substring(i + 1));
				
				for (int j : left) {
					for (int k : right) {
						if (c == '+') {
							r.add(j + k);
						}
						else if (c == '-') {
							r.add(j - k);
						}
						else if (c == '*') {
							r.add(j * k);
						}
					}
					
				}
			}
			
		}
		return r;
	}
}
