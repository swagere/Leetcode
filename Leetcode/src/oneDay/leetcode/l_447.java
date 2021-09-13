package oneDay.leetcode;

import java.util.HashMap;
import java.util.Map;

//r
public class l_447 {
	public static int numberOfBoomerangs(int[][] points) {
		Map<Integer, Integer> map;
		int sum = 0;
        for (int i = 0; i < points.length; i++) {
        	map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                Integer distance = (points[i][0] - points[j][0]) * (points[i][0] - points[j][0]) + (points[i][1] - points[j][1]) * (points[i][1] - points[j][1]);
                Integer count = map.getOrDefault(distance, 0);
                count += 1;
                map.put(distance, count);
            }
            
            for (Integer j : map.keySet()) {
                int n = map.get(j);
                sum += n * (n - 1);
            }
        }
        
        return sum;
    }

	public static void main(String[] args) {
		int[][] points = {
				{0,0},{1,0},{2,0}	
		};
		System.out.println(numberOfBoomerangs(points));

	}

}
