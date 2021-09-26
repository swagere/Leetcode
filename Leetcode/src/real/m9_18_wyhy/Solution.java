package real.m9_18_wyhy;
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 输入数字N与a,b,c，输出能被a,b,c其中一个或多个整数的第N个数
     * @param N int整型 N
     * @param a int整型 a
     * @param b int整型 b
     * @param c int整型 c
     * @return int整型
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