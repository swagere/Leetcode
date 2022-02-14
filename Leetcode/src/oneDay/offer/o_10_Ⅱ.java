package oneDay.offer;

public class o_10_¢ò {

	public static void main(String[] args) {
		System.out.println(Solution1021.numWays(7));

	}

}

//¶¯Ì¬¹æ»®
class Solution1021 {
    public static int numWays(int n) {
    	int mod = 1000000007;
    	if (n <= 1) {
    		return 1;
    	}
    	int[] step = new int[n + 1];
    	step[0] = 1;
    	step[1] = 1;
    	step[2] = 2;
        for (int i = 2; i <= n; i++) {
        	step[i] = (step[i - 1] + step[i - 2]) % mod;
        }
        
        return step[n];
    }
}