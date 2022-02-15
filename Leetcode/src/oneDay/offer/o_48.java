package oneDay.offer;

public class o_48 {

	public static void main(String[] args) {
//		String s = "dvdf";
		String s = "pwwkew";
		System.out.println(Solution482.lengthOfLongestSubstring(s));
	}

}

//模拟
class Solution481 {
    public static int lengthOfLongestSubstring(String s) {
    	int len = s.length();
    	if (len == 0) {
    		return 0;
    	}
    	int max = 1;
    	for (int i = 0; i < len; i++) {
    		StringBuffer buffer = new StringBuffer(s.substring(i, i + 1));
    		int temp = i + 1;
    		while (temp < len && buffer.indexOf(s.substring(temp, temp + 1)) == -1) {
    			buffer.append(s.substring(temp, temp + 1));
    			temp += 1;
    		}
    		max = Math.max(max, buffer.length());
    	}
    	
    	return max;
    }
}

//动态规划+字符串标记
class Solution482 {
    public static int lengthOfLongestSubstring(String s) {
    	int len = s.length();
    	if (len == 0) {
    		return 0;
    	}
    	int max = 1;
    	StringBuffer buffer = new StringBuffer(s.substring(0, 1));
    	for (int i = 1; i < len; i++) {
    		int index = buffer.indexOf(s.substring(i, i + 1));
    		if (index == -1) {
    			buffer.append(s.substring(i, i + 1));
    		}
    		else {
    			max = Math.max(max, buffer.length());
    			buffer.delete(0, index + 1);
    			buffer.append(s.substring(i, i + 1));
    		}
    	}
    	max = Math.max(max, buffer.length());
    	
    	return max;
    }
}