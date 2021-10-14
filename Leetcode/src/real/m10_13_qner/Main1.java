package real.m10_13_qner;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public int[] mergeSortedArray(int[] a, int m, int[] b, int n) {
//    	Arrays.sort(a);
//    	Arrays.sort(b);
//    	for (int i = 0; i < b.length; i++) {
//    		for (int j = 0; j < a.length; j++) {
//    			if (a[i] <= b[j]) {
//    				for (int k = a.length - 1; k > j; k--) {
//    					a[k] = a[k - 1];
//    				}
//    				a[j] = b[i];
//    				break;
//    			}
//    		}
//    	}
//    	return a;
    	int i = m;
    	int j = 0;
    	while (i < a.length) {
    		a[i] = b[j];
    		i += 1;
    		j += 1;
    	}
    	Arrays.sort(a);
    	return a;
    }
}

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;
            
        int _a_size = 0;
        _a_size = Integer.parseInt(in.nextLine().trim());
        int[] _a = new int[_a_size];
        int _a_item;
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(in.nextLine().trim());
            _a[_a_i] = _a_item;
        }
        
        int _m;
        _m = Integer.parseInt(in.nextLine().trim());
        
        int _b_size = 0;
        _b_size = Integer.parseInt(in.nextLine().trim());
        int[] _b = new int[_b_size];
        int _b_item;
        for(int _b_i = 0; _b_i < _b_size; _b_i++) {
            _b_item = Integer.parseInt(in.nextLine().trim());
            _b[_b_i] = _b_item;
        }
        
        int _n;
        _n = Integer.parseInt(in.nextLine().trim());
  
        res = new Solution().mergeSortedArray(_a, _m, _b, _n);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
