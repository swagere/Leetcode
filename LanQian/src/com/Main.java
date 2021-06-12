package com;

import java.util.Scanner;

public class Main {
	
	public static int strStr(String haystack, String needle) {
        if (needle.equals(null)) {
            return 0;
        }
        int flag = 0;
        int index = 0;
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            int k = 0;
            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) == (needle.charAt(j))) {
                    k++;
                }
            }
            if (k == needle.length()) {
                flag = 1;
                index = i;
                break;
            }
        }
        if (flag == 0) {
        	return -1;
        }
        return index;
    }

	public static void main(String[] args) {
		String haystack = "mississippi";
		String needle = "mississippi";
		System.out.println(strStr(haystack, needle));
	}

}
