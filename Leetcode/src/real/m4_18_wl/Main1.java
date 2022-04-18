package real.m4_18_wl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		String[] list = str.split(",");
		int[] list2 = new int[list.length];
		for (int i = 0; i < list.length; i++) {
			list2[i] = Integer.parseInt(list[i]);
		}
		getMinCount(list2);
		System.out.println(min);
	}
	
	public static void getMinCount(int[] arr) {
		Map<Integer, ArrayList<Integer>> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			ArrayList<Integer> list = map.getOrDefault(arr[i], new ArrayList<>());
			list.add(i);
			map.put(arr[i], list);
		}
		int[] step = new int[arr.length];
		int[] jumps = new int[arr.length];
		jump(arr, 0, map, 0, step, jumps);
	}

	static int min = Integer.MAX_VALUE;
	private static void jump(int[] arr, int index, Map<Integer, ArrayList<Integer>> map, int count, int[] step, int[] jumps) {
		if (index == arr.length - 1) {
			min = Math.min(min, count);
			return;
		}
		
		//ÓÅ»¯
		if (jumps[index] != 0 && jumps[index] < count) {
			return;
		}
		jumps[index] = count;
		
		if (index - 1 >= 0 && step[index - 1] == 0) {
			step[index - 1] = 1;
			jump(arr, index - 1, map, count + 1, step, jumps);
			step[index - 1] = 0;
		}
		if (index + 1 < arr.length && step[index + 1] == 0) {
			step[index + 1] = 1;
			jump(arr, index + 1, map, count + 1, step, jumps);
			step[index + 1] = 0;
		}
		for (int i : map.get(arr[index])) {
			if (step[i] == 0) {
				step[i] = 1;
				jump(arr, i, map, count + 1, step, jumps);
				step[i] = 0;
			}
		}
		
	}

}
