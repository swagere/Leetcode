package real.m9_16_txyy;
import java.util.*;


public class Solution2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param num string字符串 
     * @return string字符串
     */
    public static String maxLexicographical (String num) {
    	char[] strs = num.toCharArray();
        for (int i = 0; i < strs.length; i++) {
        	if (strs[i] == '0') {
        		while (i < strs.length && strs[i] == '0') {
        			strs[i] = '1';
        			i++;
        		}
        		break;
        	}
        }
        return String.copyValueOf(strs);
    }
    
    public static void main(String[] args) {
		String s = "1000";
		System.out.println(maxLexicographical(s));
	}
}