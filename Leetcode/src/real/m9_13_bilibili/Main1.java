package real.m9_13_bilibili;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution1 {
    /* Write Code Here */
    public int[] GetLeastNumbers(int[] input, int k) {
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    	for (int i = 0; i < input.length; i++) {
    		heap.add(input[i]);
    	}
    	
    	int[] numbers = new int[k];
    	for (int i = 0; i < k; i++) {
    		numbers[i] = heap.poll();
    	}
    	return numbers;
    }
}

public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int[] res;
            
        int _input_size = 0;
        _input_size = Integer.parseInt(in.nextLine().trim());
        int[] _input = new int[_input_size];
        int _input_item;
        for(int _input_i = 0; _input_i < _input_size; _input_i++) {
            _input_item = Integer.parseInt(in.nextLine().trim());
            _input[_input_i] = _input_item;
        }
        
        int _k;
        _k = Integer.parseInt(in.nextLine().trim());
  
        res = new Solution1().GetLeastNumbers(_input, _k);
        for(int res_i=0; res_i < res.length; res_i++) {
            System.out.println(String.valueOf(res[res_i]));
        }

    }
}
