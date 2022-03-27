package real.m3_27_xhs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}

		int res = getScore(n, nums);
		System.out.println(res);
	}

	private static int getScore(int n, int[] nums) {
		List<Integer> key = new ArrayList<Integer>();
		List<Integer> value = new ArrayList<Integer>();
		for (int i = 0; i < n;) {
			int count = 1;
			if (i + 1 < n && nums[i] == nums[i + 1]) {
				while (i + 1 < n && nums[i] == nums[i + 1]) {
					count += 1;
					i += 1;
				}
				key.add(nums[i]);
				value.add(count);
				i += 1;
			}
			else {
				key.add(nums[i]);
				value.add(count);
				i += 1;
			}
		}
		
		int res = 0;
		for (int i = 0; i < key.size(); i++) {
			res += value.get(i) * value.get(i);
		}
		return res;
	}

}
