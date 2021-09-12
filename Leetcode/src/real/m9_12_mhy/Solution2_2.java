package real.m9_12_mhy;

//r
public class Solution2_2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 截取字符串
     * @param original string字符串 
     * @param count int整型 
     * @return string字符串
     */
    public static String cutString (String original, int count){
    	int n = count;
    	String str = new String(original);
    	StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
        	byte[] temp = String.valueOf(str.charAt(i)).getBytes();
        	if (temp.length == 2) {
        		n -= 2;
        	}
        	if (n >= i - 1) {
        		res.append(str.charAt(i));
        	}
        }
        return res.substring(0);
    }
    
    public static void main(String[] args) {
		String original = "我ABC自DEF"; 
		int count = 6;
		System.out.println(cutString(original, count));
	}
}