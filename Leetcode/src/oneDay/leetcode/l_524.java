package oneDay.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class l_524 {
	public static String findLongestWord(String s, List<String> dictionary) {
        Collections.sort(dictionary, new Comparator<String>() {

        	@Override
			public int compare(String o1, String o2) {
                if (o2.length() == o1.length()) {
                    for (int i = 0; i < o2.length(); i++) {
                    	if (o1.charAt(i) != o2.charAt(i)) {
                    		return o1.charAt(i) - o2.charAt(i);
                    	}
                    }
                    
                    return 0;
                }
				return o2.length() - o1.length();
			}
		});
        
        String res = new String();
        for (String pattern : dictionary) {
        	int i = 0;
        	int j = 0;
        	while (i < pattern.length() && j < s.length()) {
        		if (pattern.charAt(i) == s.charAt(j)) {
        			i += 1;
        		}
        		j += 1;
        	}
        	
        	if (i == pattern.length()) {
        		res = pattern;
        		break;
        	}
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		String s = "abpcplea";
		List<String> dictionary = new ArrayList<String>();
		dictionary.add("ale");
		dictionary.add("apple");
		dictionary.add("monkey");
		dictionary.add("plea");
		System.out.println(findLongestWord(s, dictionary));

	}
}