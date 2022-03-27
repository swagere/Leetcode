package real.m3_27_xhs;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//1. DFS
//2. 动态规划
class Solution {
    /* Write Code Here */
	int max = Integer.MIN_VALUE;
    public int pathSum(int[][] array) {
    	for (int i = 0; i < array[0].length; i++) {
    		int[][] visit = new int[array.length][array[0].length];
        	getSum(array, 0, i, visit, 0);
    	}
    	return max;
    }
    
    //DFS
    public void getSum(int[][] array, int a, int b, int[][] visit, int sum) {
    	if (a < 0 || a >= array.length || b < 0 || b >= array[0].length || visit[a][b] != 0) {
    		return;
    	}
    	
    	sum += array[a][b];
    	visit[a][b] = 1;
    	
    	//如果已经到达最南边，则计算结果
    	if (a == array.length - 1) {
    		visit[a][b] = 0;
    		max = Math.max(max, sum);
    		return;
    	}
    	
    	getSum(array, a + 1, b - 1, visit, sum);
    	getSum(array, a + 1, b, visit, sum);
    	getSum(array, a + 1, b + 1, visit, sum);
    	visit[a][b] = 0;
    }
}

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;
    
        int array_rows = 0;
        int array_cols = 0;
        array_rows = in.nextInt();
        array_cols = in.nextInt();
        
        int[][] array = new int[array_rows][array_cols];
        for(int array_i=0; array_i<array_rows; array_i++) {
            for(int array_j=0; array_j<array_cols; array_j++) {
                array[array_i][array_j] = in.nextInt();
            }
        }

        if(in.hasNextLine()) {
          in.nextLine();
        }


        res = new Solution().pathSum(array);
        System.out.println(String.valueOf(res));    

    }
}
