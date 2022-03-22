package oneDay.offer;

import java.util.Arrays;

public class o_21 {

	public static void main(String[] args) {
		int[] nums = {2,4,6};
		System.out.println(Arrays.toString(Solution211.exchange(nums)));

	}

}

//Ë«Ö¸Õë
class Solution211 {
    public static int[] exchange(int[] nums) {
    	int head = 0;
    	int rear = nums.length - 1;
    	while (head < rear) {
    		while (head < nums.length &&  nums[head] % 2 != 0) {
    			head += 1;
    		}
    		while (rear > 0 && nums[rear] %2 == 0) {
    			rear -= 1;
    		}
    		if (head < rear) {
    			int temp = nums[head];
    			nums[head] = nums[rear];
    			nums[rear] = temp;
    		}
    		
    	}
    	return nums;
    }
}
