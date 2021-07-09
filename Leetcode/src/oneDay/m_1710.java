package oneDay;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class m_1710 {
	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
			}
		}
		
		Set<Integer> key = map.keySet();
		int res = -1;
		for (Integer i : key) {
			if (map.get(i) > nums.length / 2) {
				res = i;
			}
		}
		
		return res;
		
    }
	public static void main(String[] args) {
		int[] nums = {2,2,2,3,3,4,4};
		System.out.println(majorityElement(nums));
	}

}
