package real.m9_16_txyy;
import java.util.*;


public class Solution2 {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * 
     * @param num string�ַ��� 
     * @return string�ַ���
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