package real.m9_18_wyhy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution2 {
	public static void getHalf(int n, int[] val) {
		List<int[]> v = new ArrayList<int[]>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += val[i];
			v.add(new int[] {val[i], i + 1});
		}
		
		Collections.sort(v, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int s = sum / 2;
		if (sum % 2 != 0) {
			System.out.println("NO");
			return;
		}
		
		List<Integer> res = new ArrayList<Integer>();
		
		if (getSum(s, v, res, v.size() - 1)) {
			System.out.println("YES");
			
			System.out.println(n - res.size());
			for (int i = 1; i < n; i++) {
				if (!res.contains(i)) {
					System.out.print(i + " ");
				}
			}
			
			System.out.println();
			
			System.out.println(res.size());
			for (int i = 0; i < res.size(); i++) {
				System.out.print(res.get(i) + " ");
			}
		}
		else {
			System.out.println("NO");
		}
	}
    
    
    private static boolean getSum(int s, List<int[]> v, List<Integer> res, int end) {
    	if (s == 0) {
    		return true;
    	}
		for (int i = end; i >= 0; i--) {
			if (v.get(i)[0] <= s) {
				res.add(v.get(i)[1]);
				if (getSum(s - v.get(i)[0], v, res, i - 1)) {
					return true;
				}
			}
			res.remove(Integer.valueOf(v.get(i)[1]));
		}
		return false;
	}


	public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	int[] val = new int[n];
    	for (int i = 0; i < n; i++) {
    		val[i] = in.nextInt();
    	}
    	
    	getHalf(n, val);
	}
}