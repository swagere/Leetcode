package real.m9_16_txyy;
import java.util.*;

//w
//��ʱ
public class Solution3_1 {
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
        for (long i = 1;; i++) {
        	//�ó�����ת�������
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