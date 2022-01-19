package oneDay.offer;

public class o_53_Ⅱ {
	public static void main(String[] args) {
		int[] nums = {0,1,3,4,5};
		System.out.println(Solution5302.missingNumber(nums));
	}
}
//顺序查找
class Solution5301 {
    public static int missingNumber(int[] nums) {
    	if (nums[0]!=0) return 0;
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i] != i) {
    			return i;
    		}
    	}
    	return nums.length;
    }
}

//二分查找/分治
class Solution5302 {
    public static int missingNumber(int[] nums) {
    	int i = 0;
    	int j = nums.length - 1;
    	while (i <= j) {
    		int m = (i + j) / 2;
    		if (nums[m] == m) {
    			i = m + 1;
    		}
    		else {
    			j = m - 1;
    		}
    	}
    	return i;
    }
}