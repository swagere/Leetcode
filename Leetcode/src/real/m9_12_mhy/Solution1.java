package real.m9_12_mhy;

import java.util.PriorityQueue;

public class Solution1 {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * 
     * @param nums int����һά���� 
     * @param k int���� 
     * @return int����
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