package real.m9_18_wyhy;
import java.util.*;

import real.m8_23_aqx.main1;


public class Solution1_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 找出所有在source中出现过的table中的元素，并统计其出现次数。
# 返回值为一个二维数组，返回格式为：
# [
#     [字符串在table中的下标，出现次数],
#     [字符串在table中的下标，出现次数]
# ]
# 其中第一维的元素需要按子字符串在table中的下标升序排列。
# 未出现的子字符串，无需返回。
     * @param source string字符串 源字符串，长度大于0，小于10^8
     * @param table string字符串一维数组 待查找的子字符串列表。列表长度大于0，小于10^5，其中的字符串，长度大于0，小于20
     * @return int整型二维数组
     */
    public static int[][] search_substr (String source, String[] table) {
    	List<Integer> visited = new ArrayList<Integer>();
    	Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int i = 0; i < table.length; i++) {
        	int count = 0;
            for (int j = 0; j < source.length(); j++) {
                if (!visited.contains(j)) {
                	if (source.charAt(j) == table[i].charAt(0)) {
                		int s = j;
                		int t = 0;
                		List<Integer> temp = new ArrayList<Integer>();
                		while (s < source.length() && t < table[i].length() && source.charAt(s) == table[i].charAt(t)) {
                			temp.add(s);
                			s += 1;
                			t += 1;
                		}
                		
                		if (t == table[i].length()) {
                			count += 1;
                			visited.addAll(temp);
                		}
                	}
                }
            }
            if (count != 0) {
            	res.put(i, count);
            }
        }
        
        int[][] r = new int[res.size()][2];
        int index = 0;
        for (Integer key : res.keySet()) {
        	r[index][0] = key;
        	r[index][1] = res.get(key);
        	index += 1;
        }
        return r;
    }
    
    public static void main(String[] args) {
//		String source = "ABCDEFG";
    	String source = "ABCD EFG# ABF";
		String[] table = {
//				"AB", "ABC", "FG"
				"ABCD E", "# A", "F", "WX"
		};
		System.out.println(Arrays.deepToString(search_substr(source, table)));
	}
}