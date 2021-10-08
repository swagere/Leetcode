package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//w
//³¬Ê±
class l_187_1 {
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<String>();
        for (int i = 0; i + 10 < s.length(); i++) {
            String temp = s.substring(i, i + 10);
            if (res.contains(temp)) {
            	continue;
            }
            String rest = s.substring(i + 1);
            if (rest.contains(temp)) {
            	res.add(temp);
            }

        }
        return res;
    }
    
    public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		System.out.println(findRepeatedDnaSequences(s));
	}
}