package oneDay.offer;

public class o_58 {

	public static void main(String[] args) {
		String s = "abcdefg";
		int k = 2;
		Solution581 so = new Solution581();
		System.out.println(so.reverseLeftWords(s, k));
	}

}

class Solution581 {
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
