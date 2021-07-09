package oneDay.leetcode;

//int[]

public class l_1711_1 {
	public static boolean isTwoTimes(int i) {
		boolean flag = false;
		while (true) {
			if (i == 1) {
				flag = true;
				break;
			}
			else if (i % 2 != 0) {
				break;
			}
			else if (i == 2) {
				flag = true;
				break;
			}
			i = i / 2;
		}
		
		
		return flag;
		
	}
	
	public static int countPairs(int[] deliciousness) {
		//max
		int max = deliciousness[0];
		for (int i : deliciousness) {
			if (max < i) {
				max = i;
			}
		}
		
		int length = max + 1;
		int sum = 0;
        int[] count = new int[length];
        for (int i : deliciousness) {
        	count[i]++;
        }
        
        for (int i = 0; i < length; i++) {
    		if (count[i] > 0) {
    			if (count[i] > 1) {
        			if (isTwoTimes(i * 2)) {
        				sum = sum + count[i] * (count[i] - 1) / 2;
        			}
        		}
    			for (int j = i + 1; j < length; j++) {
        			if (count[j] != 0) {
        				if (isTwoTimes(i + j)) {
        					sum = sum + count[i] * count[j];
        				}
        			}
        		}
    		}
    		
        	
        }
        return sum;
    }

	public static void main(String[] args) {
		int[] deliciousness = {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
		System.out.println(countPairs(deliciousness));

	}

}