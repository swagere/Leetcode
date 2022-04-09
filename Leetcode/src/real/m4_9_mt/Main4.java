package real.m4_9_mt;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(getWay(n));
	}

	static Set<String> res = new HashSet<>();
	private static int getWay(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < n; l++) {
						if (i == j || i == k || j == l || k == l) {
							continue;
						}
						else {
							res.add(new StringBuffer().append(i).append(j).append(k).append(l).toString());
						}
					}
				}
			}
		}
		return res.size();
	}
	
	

}
