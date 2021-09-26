package real.m9_18_wyhy;
import java.util.*;


public class Solution {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * ��������N��a,b,c������ܱ�a,b,c����һ�����������ĵ�N����
     * @param N int���� N
     * @param a int���� a
     * @param b int���� b
     * @param c int���� c
     * @return int����
     */
    public int findNthNumber (int N, int a, int b, int c) {
    	int mod = 1000000007;
        long res = 1;
        for (int i = 1; ; i++) {
            if (i % a == 0) {
                N--;
            }
            else if (i % b == 0) {
                N--;
            }
            else if (i % c == 0) {
                N--;
            }
            if (N == 0) {
                res = i % mod;
                break;
            }
        }
        return (int) res;
    }
}