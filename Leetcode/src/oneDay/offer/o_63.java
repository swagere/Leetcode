package oneDay.offer;

public class o_63 {

	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		System.out.println(Solution0633.maxProfit(prices));

	}

}

//最大最小值
class Solution0631 {
    public static int maxProfit(int[] prices) {
    	int n = prices.length;
    	if (n <= 1) {
    		return 0;
    	}
    	int[] min = new int[n];
    	int in = prices[0];
    	min[0] = in;
    	for (int i = 1; i < n; i++) {
    		if (in > prices[i]) {
    			in = prices[i];
    		}
    		min[i] = in;
    	}
    	
    	int[] max = new int[n];
    	int ax = prices[n - 1];
    	max[n - 1] = ax;
    	for (int i = n - 2; i >= 0; i--) {
    		if (ax < prices[i]) {
    			ax = prices[i];
    		}
    		max[i] = ax;
    	}
    	
    	int res = 0;
    	for (int i = 0; i < n; i++) {
    		if (res < max[i] - min[i]) {
    			res = max[i] - min[i];
    		}
    	}
    	
    	return res;
    }
}

//优化 最小值
class Solution0632 {
    public static int maxProfit(int[] prices) {
    	int n = prices.length;
    	if (n <= 1) {
    		return 0;
    	}
    	int[] min = new int[n];
    	int in = prices[0];
    	min[0] = in;
    	for (int i = 1; i < n; i++) {
    		if (in > prices[i]) {
    			in = prices[i];
    		}
    		min[i] = in;
    	}
    	
    	int res = 0;
    	for (int i = 0; i < n; i++) {
    		if (res < prices[i] - min[i]) {
    			res = prices[i] - min[i];
    		}
    	}
    	
    	return res;
    }
}

//优化 动态规划
class Solution0633 {
    public static int maxProfit(int[] prices) {
    	int n = prices.length;
    	if (n <= 1) {
    		return 0;
    	}
    	int min = prices[0];
    	int res = 0;
    	for (int i = 0; i < n; i++) {
    		if (min > prices[i]) {
    			min = prices[i];
    		}
    		if (res < prices[i] - min) {
    			res = prices[i] - min;
    		}
    	}
    	
    	return res;
    }
}