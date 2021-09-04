package oneDay.leetcode;

//��ʱ
//�ݹ� 
public class l_1137_1 {
	public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1 || n == 2) {
            return 1;
        }
        return tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3);
    }

	public static void main(String[] args) {
		int n = 35;
		System.out.println(tribonacci(n));

	}

}
