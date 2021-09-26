package real.m9_16_txyy;
import java.util.*;


public class Solution3_2 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param n int整型 
     * @param k int整型 
     * @return long长整型
     */
    public static long minM (int n, int k) {
    	long count = 0;
    	long res = 0;
    	List<Integer> cur = new ArrayList<Integer>();
    	cur.add(0);
    	long cur_num = 0;
        for (long i = 1;; i++) {
        	//得出进制转换后的数
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