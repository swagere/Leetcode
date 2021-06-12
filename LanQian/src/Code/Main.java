package Code;

import java.util.Date;
import java.util.Scanner;

public class Main {
  

    public static void main(String[] args) {
    	int[][] f = new int[5][9];
    	int[] w = {0,2,3,4,5};
    	int[] v = {0,3,4,5,8};
    	
    	for (int i = 1; i < 5; i++) {
    		for (int j = 1; j < 9; j++) {
    			if (w[i] > j) {
    				f[i][j] = f[i - 1][j];
    			}
    			else {
    				f[i][j] = max(f[i - 1][j], f[i - 1][j - w[i]] + v[i]);
    			}
    		}
    	}
        
    	for (int i = 0; i < 5; i++) {
    		for (int j = 0; j < 9; j++) {
    			System.out.println("f[" + i + "][" + j + "] = " + f[i][j]);
    		}
    	}
    }

	private static int max(int i, int j) {
		if (i > j) {
			return i;
		}
		return j;
	}

   
}