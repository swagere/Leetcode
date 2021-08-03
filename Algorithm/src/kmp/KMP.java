package kmp;

import java.util.Arrays;

//kmp算法
public class KMP {

	public static void main(String[] args) {
		String s1 = "BBC ABCDAB ABCDABCDABDE";
		String s2 = "ABCDABD";
		
		System.out.println(kmp(s1, s2));

	}

	private static int kmp(String s1, String s2) {
		//先得出next串 部分匹配表
		int[] next = getNext(s2);
		
		System.out.println(Arrays.toString(next));
		//再由next串计算出结果
		int i = 0;
		int j = 0;
		while (i < s1.length()) {
			//回到上一次能匹配的位置
			while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
				j = next[j - 1];
			}
			
			//判断是否相等
			if (s1.charAt(i) == s2.charAt(j)) {
				j++;
			}
			
			if (j == s2.length()) {
				return i - j + 1;
			}
			i++;
		}
		
		return -1;
	}

	//得到部分匹配表
	private static int[] getNext(String s) {
		int[] next = new int[s.length()];
		
		int i = 1;
		int j = 0;
		next[0] = 0;
		while (i < s.length()) {
			
			//如果不等则跳到不匹配值之前的值，直到找到结果
			//放在前面 先找到上次相等的点
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = next[j - 1];
			}
			
			//然后再比较
			if (s.charAt(i) == s.charAt(j)) {
				//如果相等则直接向后继续寻找
				j++;
			}
			
			next[i] = j;
			i++;
		}
		return next;
	}

}
