package real.m9_12_mhy;

import java.util.PriorityQueue;

public class Solution1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @param k int整型 
     * @return int整型
     */
    public static int findKthLargest (int[] nums, int k) {
    	PriorityQueue<Integer> heap = new PriorityQueue<Integer>((a,b)->b-a);
    	for (int i = 0; i < nums.length; i++) {
    		heap.add(nums[i]);
    	}
    	
    	int res = 0;
    	for (int i = 0; i < k; i++) {
    		res = heap.poll();
    	}

    	return res;
    }
    
    public static void main(String[] args) {
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(findKthLargest(nums, k));
	}
    
    
}