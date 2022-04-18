package real.m4_18_wl;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String source = in.nextLine();
		String target = in.nextLine();
		System.out.println(getMinString(source, target));
	}
	
	public static String getMinString(String source, String target) {
		char[] s = source.toCharArray();
		char[] t = target.toCharArray();
		String min = source;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < t.length; j++) {
				int start = i;
				for (int k = i; k < s.length; k++) {
					if (s[k] == t[j]) {
						if (j == 0) start = k;
						j += 1;
					}
					if (j == t.length) {
						min = min.length() < k - i ? min : source.substring(start, k + 1); 
						break;
					}
				}
				break;
			}
		}
		return min;
	}

}
