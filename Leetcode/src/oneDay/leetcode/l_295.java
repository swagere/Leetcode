package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

public class l_295 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MedianFinder {
    List<Integer> nums;

    /** initialize your data structure here. */
    MedianFinder() {
    	nums = new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
    	int i = 0;
    	for (i = 0; i < nums.size(); i++) {
    		if (num < nums.get(i)) {
    			break;
    		}
    	}
    	nums.add(i, num);
    }
    
    public double findMedian() {
    	int n = nums.size();
    	if (n % 2 == 0) {
    		return (nums.get(n / 2 - 1) + nums.get(n / 2)) / (double)2;
    	}
    	else {
    		return nums.get(n / 2);
    	}
    }
}