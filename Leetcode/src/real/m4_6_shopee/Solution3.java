package real.m4_6_shopee;
import java.util.*;
import java.util.Map.Entry;


 
public class Solution3 {
	public static void main(String[] args) {
		System.out.println(new Solution3().buildHouses(1));
	}
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     * 
     * @param n int整型  
     * @return int整型
     */
	int count = 0;
    public int buildHouses(int n) {
    	
		Map<Integer, Integer> map = new HashMap<>();
		build(n, map, 0);
    	
    	return count;
    }
    
    public void build(int n, Map<Integer, Integer> loc, int i) {
    	if (i == n) {
    		if (loc.size() == n) {
    			count += 1;
    		}
    		return;
    	}
    	for (int j = 0; j < n; j++) {
    		if (canBuild(loc, i, j)) {
    			loc.put(i, j);
    			build(n, loc, i + 1);
    			loc.remove(i);
    		}
    	}
    }

	private boolean canBuild(Map<Integer, Integer> loc, int i, int j) {
		if (loc.containsKey(i) || loc.containsValue(j)) {
			return false;
		}
		for (Entry<Integer, Integer> item : loc.entrySet()) {
			if (item.getKey() - i == item.getValue() - j || item.getKey() - i == j - item.getValue()) {
				return false;
			}
		}
		return true; 
	}
}
