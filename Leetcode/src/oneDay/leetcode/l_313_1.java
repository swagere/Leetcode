package oneDay.leetcode;

//超时
//一个一个排除
public class l_313_1 {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1) {
			return 1;
		}
		
		int index = 1;
		for (int i = primes[0];; i++) {
			int temp = i;
			for (int j = 0; j < primes.length; j++) {
				while (temp % primes[j] == 0) {
					temp = temp / primes[j];
				}
			}
			
			if (temp == 1) {
				index += 1;
				
				if (index == n) {
					return i;
				}
			}
			
		}
    }

	public static void main(String[] args) {
//		int n = 100000;
		int n = 12;
		int[] primes = {2,7,13,19};
//		int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};

		System.out.println(nthSuperUglyNumber(n, primes));
	}

}
