package real.m9_16_txyy;
import java.util.*;

//w
//超时
public class Solution3_1 {
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
        for (long i = 1;; i++) {
        	//得出进制转换后的数
        	long temp = i;
        	while (temp >= k) {
        		if (temp % k == 1) {
        			count += 1;
        		}
        		temp /= k;
        	}
        	if (temp % k == 1) {
        		count += 1;
    		}
        	
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