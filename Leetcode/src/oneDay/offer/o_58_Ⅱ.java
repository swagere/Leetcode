package oneDay.offer;

public class o_58_¢ò {

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		Solution5821 so = new Solution5821();
		System.out.println(so.reverseLeftWords(s, k));
	}

}

class Solution5821 {
    public String reverseLeftWords(String s, int n) {
    	if (s.length() <= 1) {
    		return s;
    	}
    	int len = s.length();
    	int index = n;
    	StringBuffer str = new StringBuffer();
    	while (index != n - 1) {
    		str.append(s.charAt(index));
    		index = (index + 1) % len;
    	}
    	str.append(s.charAt((n - 1) % len));
    	return str.toString();
    }
}
