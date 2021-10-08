package oneDay.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//r
//´æ´¢Ã¿Ò»¸ö×Ö·û´®£¬·ÀÖ¹ÖØ¸´Ñ°ÕÒ
class l_187_3 {
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<String>();
    	Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i + 10 <= s.length(); i++) {
        	String temp = s.substring(i, i + 10);
        	Integer count = map.getOrDefault(temp, 0);
        	map.put(temp, count + 1);

        }
        
        for (String key : map.keySet()) {
        	if (map.get(key) > 1) {
        		res.add(key);
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
//		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
    	String s = "AAAAAAAAAAA";
		System.out.println(findRepeatedDnaSequences(s));
	}
}