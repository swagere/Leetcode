package real.m8_8_pdd;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long t = sc.nextLong();
        int c = sc.nextInt();
        
        long[] sweet = new long[n];
        for (int i = 0; i < n; i++) {
        	sweet[i] = sc.nextLong();
        }
        
        //ÅÅÐò
        Arrays.sort(sweet);
        
        //¶þ·Ö²éÕÒ
        int left = 0;
        int right = n - 1;
        while (left <= right) {
        	int mid = (left + right) / 2;
        	if (sweet[mid] < t) {
        		left = mid + 1;
        	}
        	else{
        		right = mid - 1;
        	}
        }
        System.out.println(right);
        
        System.out.println(Math.max(right + 2 - c, 0));

	}

}
