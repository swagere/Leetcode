package oneDay.offer;

public class o_05 {

	public static void main(String[] args) {
		String s = "We are happy.";
		Solution052 so = new Solution052();
		System.out.println(so.replaceSpace(s));

	}

}
class Solution051 {
    public String replaceSpace(String s) {
        StringBuffer str = new StringBuffer();
        for (char c : s.toCharArray()) {
        	if (c != ' ') {
        		str.append(c);
        	}
        	else {
        		str.append("%20");
        	}
        }
        return str.toString();
    }
}
class Solution052 {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }
}