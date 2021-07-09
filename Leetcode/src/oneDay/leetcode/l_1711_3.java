package oneDay.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//map hashMap
//判断是否为2的幂 用有限数组

public class l_1711_3 {
	public static boolean isTwoTimes(int i, List<Integer> aims) {
		if (aims.contains(i)) {
			return true;
		}
		
		return false;
		
	}
	
	public static int countPairs(int[] deliciousness) {
		//初始化目标待比较数组：2的次方
		List<Integer> aims = new ArrayList<>();
		aims.add(1);
		for (int i = 1; i < 22; i++) {
			aims.add(aims.get(i - 1)*2);
		}
		
		int mod = 1000000007;
		int sum = 0;
		int sum1 = 0;
		int sum2 = 0;
		
		//初始化输入数组 提取每个值并记录数量
		Map<Integer, Integer> map = new HashMap<>();
        for (int i : deliciousness) {
        	if (map.containsKey(i)) {
        		map.put(i, map.get(i) + 1);
        	}
        	else {
        		map.put(i, 1);
        	}
        }
        
        //依次比较
        Object[] set = map.keySet().toArray();
        for (int i = 0; i < set.length; i++) {
			if (map.get(set[i]) > 1) {
    			if (isTwoTimes((int)set[i] * 2, aims)) {
    				sum = (sum + map.get(set[i]) * (map.get(set[i]) - 1) / 2) % mod;
    				sum1 = sum1 + map.get(set[i]) * (map.get(set[i]) - 1) / 2;
    			}
    		}
		
			for (int j = i + 1; j < set.length; j++) {
				if (isTwoTimes((int)set[i] + (int)set[j], aims)) {
					sum = (sum + map.get(set[i]) * map.get(set[j])) % mod;
					sum2 = sum2 + map.get(set[i]) * map.get(set[j]);
				}
    		}
    		
        	
        }
        
        return sum;
    }

	public static void main(String[] args) {
//		int[] deliciousness = {};
//		int[] deliciousness = {1,3,5,7,9};
		int[] deliciousness = {188,68,496,16,1,1,418,3678,9,23,27,101,552,1496,245,11,1,7,31894,874,853,171,0,1,30586,2182,6229,10155,61,3,24,40,398,114,8,0,10,6,59,5,49,79,14,2,1877,171,55,9,26,102,26444,6324,1,3,25174,7594,2490,5702,6,2,57,71,43,4053,35,93,5364,11020,2,2,256,256,541,7651,0,4,20220,12548,6632,1560,4,0,15,17,6,26,32028,740,3896,200,1,1,9,55,8089,103,0,1,93,1955,956,68,2,2,768,256,1,1,44,20,6,10,6,10,884,1164,4057,12327,102,26,5,3,12031,20737,26320,6448,29240,3528};
		System.out.println(countPairs(deliciousness));

	}

}