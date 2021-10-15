package oneDay.leetcode;

//r
//Ä£Äâ
public class l_38 {
	public static String countAndSay(int n) {
        StringBuffer str = new StringBuffer("1"); 
        
        for (int i = 1; i < n; i++) {
        	StringBuffer temp = new StringBuffer();
        	for (int j = 0; j < str.length(); j++) {
        		int index = j;
    			while (index + 1 < str.length() && str.charAt(index) == str.charAt(index + 1)) {
    				index += 1;
    			}
    			temp.append(index - j + 1);
    			temp.append(str.charAt(j));
    			j = index;
        	}
        	str = temp;
        }
        return str.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(countAndSay(4));

	}

}
