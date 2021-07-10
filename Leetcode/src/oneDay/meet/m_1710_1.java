package oneDay.meet;

//r
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class m_1710_1 {
	public static int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int res = -1;
		for (int i : nums) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}
			else {
				map.put(i, 1);
			}
			if (map.get(i) > nums.length / 2) {
				res = i;
				break;
			}
			
		}
		
		return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println(majorityElement(nums));
	}

}
