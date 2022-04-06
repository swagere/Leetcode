package oneDay.leetcode;

public class l_198 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//dp
class Solution1981 {
    public int rob(int[] nums) {
        int a = 0;
        int b = 0;
        for (int i : nums) {
            a = Math.max(a + i, b);
            int temp = a;
            a = b;
            b = temp;
        } 
        return b;
    }
} 