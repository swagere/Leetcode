package real.m4_6_shopee;
import java.util.*;


 
public class Solution2 {
	public static void main(String[] args) {
		String s = "ABAA";
		System.out.println(new Solution2().MinOperations(s));
	}
    /**
     * Note: ���������������������Ѿ�ָ���������޸�
     *
     *
     * 
     * @param s string�ַ���  
     * @return int����
     */
    public int MinOperations(String s) {
    	char[] str = s.toCharArray();
    	int count1 = 0;
        for (int i = 1; i < s.length(); i++) {
        	if (str[i - 1] == str[i]) {
        		count1 += 1;
        		if (str[i] == 'A') str[i] = 'B';
        		else if (str[i] == 'B') str[i] = 'A';
        		i -= 1;
        	}
        }
        
        str = s.toCharArray();
        int count2 = 0;
        for (int i = s.length() - 1; i > 0; i--) {
        	if (str[i - 1] == str[i]) {
        		count2 += 1;
        		if (str[i - 1] == 'A') str[i - 1] = 'B';
        		else if (str[i - 1] == 'B') str[i - 1] = 'A';
        		i += 1;
        	}
        }
        
        return Math.min(count1, count2);
    }
}
