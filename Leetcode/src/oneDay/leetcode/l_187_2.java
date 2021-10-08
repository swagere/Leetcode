package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//w
//³¬Ê±
class l_187_2 {
    public static List<String> findRepeatedDnaSequences(String s) {
    	List<String> res = new ArrayList<String>();
        for (int i = 0; i + 10 <= s.length(); i++) {
        	if (res.contains(s.substring(i, i + 10))) {
        		continue;
        	}
            for (int j = i + 1; j + 10 <= s.length(); j++) {
            	int a = i;
            	int b = j;
            	int flag = 0;
            	while (flag < 10 && a < s.length() && b < s.length() && s.charAt(a) == s.charAt(b)) {
            		a += 1;
            		b += 1;
            		flag += 1;
            	}
            	if (flag == 10) {
            		res.add(s.substring(i, i + 10));
            		break;
            	}
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