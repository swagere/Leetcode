package real.m9_13_bilibili;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public int[] GetSortedTasks(int[][] taskLists) {
//    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    	
    	int count = 0;
    	int row = taskLists.length;
    	int col = taskLists[0].length;
    	int[] num = new int[row * col];
    	for (int i = 0; i < row; i++) {
    		for (int j = 0; j < col; j++) {
//    			heap.add(taskLists[i][j]);
    			num[count] = taskLists[i][j];
    			count += 1;
    		}
    	}
    	
    	Arrays.sort(num);
    	return num;
    }
}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;
    
        int _taskLists_rows = 0;
        int _taskLists_cols = 0;
        _taskLists_rows = Integer.parseInt(in.nextLine().trim());
        _taskLists_cols = Integer.parseInt(in.nextLine().trim());
        
        int[][] _taskLists = new int[_taskLists_rows][_taskLists_cols];
        for(int _taskLists_i=0; _taskLists_i<_taskLists_rows; _taskLists_i++) {
            for(int _taskLists_j=0; _taskLists_j<_taskLists_cols; _taskLists_j++) {
                _taskLists[_taskLists_i][_taskLists_j] = in.nextInt();
                
            }
        }
        
        if(in.hasNextLine()) {
          in.nextLine();
        }
  
        res = new Solution().GetSortedTasks(_taskLists);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
