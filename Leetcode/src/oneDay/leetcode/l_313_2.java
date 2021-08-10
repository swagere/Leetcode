package oneDay.leetcode;

import java.util.TreeSet;

//r
//优先队列+有序
public class l_313_2 {
	public static int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1) {
			return 1;
		}
		
		TreeSet<Long> queue = new TreeSet<>();
		long cur = 1L;
		while (n > 1) {
			for (int i = 0; i <primes.length; i++) {
				queue.add(cur * primes[i]);
			}
			cur = queue.pollFirst();
			n--;
		}
		return (int) cur;
    }

	public static void main(String[] args) {
//		int n = 100000;
		int n = 12;
		int[] primes = {2,7,13,19};
//		int[] primes = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251};

		System.out.println(nthSuperUglyNumber(n, primes));
	}

}
