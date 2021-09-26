package real.m9_18_wyhy;
import java.util.*;

import real.m8_23_aqx.main1;


public class Solution1_1 {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * �ҳ�������source�г��ֹ���table�е�Ԫ�أ���ͳ������ִ�����
# ����ֵΪһ����ά���飬���ظ�ʽΪ��
# [
#     [�ַ�����table�е��±꣬���ִ���],
#     [�ַ�����table�е��±꣬���ִ���]
# ]
# ���е�һά��Ԫ����Ҫ�����ַ�����table�е��±��������С�
# δ���ֵ����ַ��������践�ء�
     * @param source string�ַ��� Դ�ַ��������ȴ���0��С��10^8
     * @param table string�ַ���һά���� �����ҵ����ַ����б��б��ȴ���0��С��10^5�����е��ַ��������ȴ���0��С��20
     * @return int���Ͷ�ά����
     */
    public static int[][] search_substr (String source, String[] table) {
    	List<Integer> visited = new ArrayList<Integer>();
    	Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int i = 0; i < table.length; i++) {
        	int count = 0;
            for (int j = 0; j < source.length(); j++) {
                if (!visited.contains(j)) {
                	if (source.charAt(j) == table[i].charAt(0)) {
                		int s = j;
                		int t = 0;
                		List<Integer> temp = new ArrayList<Integer>();
                		while (s < source.length() && t < table[i].length() && source.charAt(s) == table[i].charAt(t)) {
                			temp.add(s);
                			s += 1;
                			t += 1;
                		}
                		
                		if (t == table[i].length()) {
                			count += 1;
                			visited.addAll(temp);
                		}
                	}
                }
            }
            if (count != 0) {
            	res.put(i, count);
            }
        }
        
        int[][] r = new int[res.size()][2];
        int index = 0;
        for (Integer key : res.keySet()) {
        	r[index][0] = key;
        	r[index][1] = res.get(key);
        	index += 1;
        }
        return r;
    }
    
    public static void main(String[] args) {
//		String source = "ABCDEFG";
    	String source = "ABCD EFG# ABF";
		String[] table = {
//				"AB", "ABC", "FG"
				"ABCD E", "# A", "F", "WX"
		};
		System.out.println(Arrays.deepToString(search_substr(source, table)));
	}
}