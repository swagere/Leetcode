package real.m9_12_mhy;
import java.util.*;

//w
//莫名其妙
public class Solution2_1 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 截取字符串
     * @param original string字符串 
     * @param count int整型 
     * @return string字符串
     */
    public static String cutString (String original, int count){
        byte[] bytes = original.getBytes();
        System.out.println(Arrays.toString(bytes));
        
        if (bytes[count - 1] < 0 && bytes[count] < 0) {
        	byte[] res = Arrays.copyOf(bytes, count - 1);
        	return new String(res);
        }
        else {
        	byte[] res = Arrays.copyOf(bytes, count);
        	return new String(res);
        }
    }
    
    public static void main(String[] args) {
		String original = "我ABC自DEF";
		int count = 8;
		System.out.println(cutString(original, count));
	}
}