package offer;

//r
//¶¯Ì¬¹æ»®
public class o_10_2 {
	static int mod = 1000000007;
	static int[] step;
	public static int numWays(int n) {
		step = new int[n + 1];
        return jump(0, n);
    }

    public static int jump(int i, int n) {
        if (i == n) {
            return 1;
        }
        else if (i > n) {
        	return 0;
        }
        else if (step[i] != 0) {
        	return step[i];
        }

        int res = (jump(i + 1, n) + jump(i + 2, n)) % mod;
        step[i] = res;
        return res;
    }
	public static void main(String[] args) {
		int n = 43;
		System.out.println(numWays(n));

	}

}
