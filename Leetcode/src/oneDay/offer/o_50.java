package oneDay.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class o_50 {

	public static void main(String[] args) {
		String s = "leetcode";
		System.out.println(Solution503.firstUniqChar(s));
	}

}
//两个list实现
class Solution501 {
    public static char firstUniqChar(String s) {
    	List<Character> single = new ArrayList<>();
    	List<Character> d = new ArrayList<>();
    	for (char c : s.toCharArray()) {
    		if (!single.contains(c) && !d.contains(c)) {
    			single.add(c);
    		}
    		else if (single.contains(c)){
    			single.remove(Character.valueOf(c));
    			d.add(c);
    		}
    	}
    	if (single.size() == 0) {
    		return ' ';
    	}
    	return single.get(0);
    }
}

//一个哈希表实现:linkedMashMap（按照存入顺序）
class Solution502 {
    public static char firstUniqChar(String s) {
    	Map<Character, Integer> map = new LinkedHashMap<>();
    	for (char c : s.toCharArray()) {
    		map.put(c, map.getOrDefault(Character.valueOf(c), 0) + 1);
    	}
    	for (char c : map.keySet()) {
    		if (map.get(Character.valueOf(c)) == 1) {
    			return c;
    		}
    	}
    	return ' ';
    }
}

//一个哈希表实现:MashMap（按照hash后的顺序存储）
class Solution503 {
  public static char firstUniqChar(String s) {
  	Map<Character, Boolean> map = new HashMap<>();
  	for (char c : s.toCharArray()) {
  		map.put(c, map.get(Character.valueOf(c)) != null);
  	}
  	for (char c : s.toCharArray()) {
  		if (!map.get(Character.valueOf(c))) {
  			return c;
  		}
  	}
  	return ' ';
  }
}