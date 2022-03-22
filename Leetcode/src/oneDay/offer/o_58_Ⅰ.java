package oneDay.offer;

public class o_58_¢ñ {
	public static void main(String arg[]) {
		String s = "a good   example";
		System.out.println(Solution5812.reverseWords(s));
	}
}
//¿âº¯Êý
class Solution5811 {
    public static String reverseWords(String s) {
    	String[] str = s.trim().split(" ");
    	StringBuffer buffer = new StringBuffer();
    	for (int i = str.length - 1; i >= 0; i--) {
    		if (!str[i].equals("")) {
    			buffer.append(str[i].trim());
        		if (i != 0) {
        			buffer.append(" ");
        		}
    		}
    	}
    	return buffer.toString();
    }
}

//Ë«Ö¸Õë
class Solution5812 {
    public static String reverseWords(String s) {
    	s = s.trim();
    	StringBuffer buffer = new StringBuffer();
    	for (int i = s.length() - 1; i >= 0;) {
    		if (s.charAt(i) != ' ') {
    			int right = i;
    			while (i >= 0 && s.charAt(i) != ' ') {
    				i -= 1;
    			}
    			int left = i + 1;
    			buffer.append(s.substring(left, right + 1));
    			if (left != 0) {
    				buffer.append(" ");
    			}
    		}
    		else {
    			i -= 1;
    		}
    	}
    	return buffer.toString();
    }
}