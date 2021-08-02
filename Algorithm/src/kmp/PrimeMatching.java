package kmp;

//±©¡¶∆•≈‰ º¥∆”Àÿ∆•≈‰À„∑®
public class PrimeMatching {

	public static void main(String[] args) {
		String s1 = "AABCAAAD";
		String s2 = "AAD";
		
		System.out.println(primeMatching(s1, s2));

	}

	//∆”Àÿ∆•≈‰À„∑®
	private static int primeMatching(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int i = 0;
		int j = 0;
		
		while (i < c1.length && j < c2.length) {
			if (c1[i] == c2[j]) {
				i++;
				j++;
			}
			else {
				i = i - j + 1;
				j = 0;
			}
			
			if (j == c2.length) {
				return i - j;
			}
		}
		return -1;
	}

}
