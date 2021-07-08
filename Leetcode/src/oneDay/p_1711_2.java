package oneDay;

import java.util.HashMap;
import java.util.Map;

//map hashMap

public class p_1711_2 {
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
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();
        for (int i : deliciousness) {
        	if (map.containsKey(i)) {
        		map.put(i, map.get(i) + 1);
        	}
        	else {
        		map.put(i, 1);
        	}
        }
        
        Object[] set = map.keySet().toArray();
        for (int i = 0; i < set.length; i++) {
			if (map.get(set[i]) > 1) {
    			if (isTwoTimes((int)set[i] * 2)) {
    				sum = sum + map.get(set[i]) * (map.get(set[i]) - 1) / 2;
    			}
    		}
		
			for (int j = i + 1; j < set.length; j++) {
				if (isTwoTimes((int)set[i] + (int)set[j])) {
					sum = sum + map.get(set[i]) * map.get(set[j]);
				}
    		}
    		
        	
        }
        
        return sum;
    }

	public static void main(String[] args) {
		int[] deliciousness = {2160,1936,3,29,27,5,2503,1593,2,0,16,0,3860,28908,6,2,15,49,6246,1946,23,105,7996,196,0,2,55,457,5,3,924,7268,16,48,4,0,12,116,2628,1468};
//		int[] deliciousness = {1,3,5,7,9};
		System.out.println(countPairs(deliciousness));

	}

}