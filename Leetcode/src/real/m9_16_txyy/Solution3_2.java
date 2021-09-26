package real.m9_16_txyy;
import java.util.*;


public class Solution3_2 {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * 
     * @param n int���� 
     * @param k int���� 
     * @return long������
     */
    public static long minM (int n, int k) {
    	long count = 0;
    	long res = 0;
    	List<Integer> cur = new ArrayList<Integer>();
    	cur.add(0);
    	long cur_num = 0;
        for (long i = 1;; i++) {
        	//�ó�����ת�������
        	if (cur.get(cur.size() - 1) + 1 < k) {
        		int temp = cur.get(cur.size() - 1) + 1;
        		cur.set(cur.size() - 1, temp);
        		if (temp == 1) {
        			cur_num += 1;
        		}
        		else if (temp == 2){
        			cur_num -= 1;
        		}
        		
        	}
        	else {
        		int len = cur.size() - 1;
        		while (len >= 0 && cur.get(len) + 1 == k) {
        			cur.set(len, 0);
        			len --;
        			if (k == 2) {
        				cur_num -= 1;
        			}
        		}
        		if (len < 0) {
        			cur.add(0, 1);
        			cur_num += 1;
        		}
        		else  {
        			int temp = cur.get(len) + 1;
        			cur.set(len, temp);
        			if (temp == 1) {
        				cur_num += 1;
        			}
        			else if (temp == 2) {
        				cur_num -= 1;
        			}
        		}
        	}
        	System.out.println(cur);
        	System.out.println(cur_num);
        	count += cur_num;
        	
        	if (count >= n) {
        		res = i;
        		break;
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
		int n = 10;
		int k = 10;
		System.out.println(minM(n, k));
    }
}