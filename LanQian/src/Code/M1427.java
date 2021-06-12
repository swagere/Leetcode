package Code;

import java.util.Scanner;

public class M1427 {
	//得到最大公因数
	static int getMaxEachPrime(int n, int m) {
		//拉格朗日最大公因数
		int r = n % m;
		n = m;
		m = r;
		while(r != 0) {
			r = n % m;
			n = m;
			m = r;
		}
		return n;
	}
	
	//得到最小公倍数
	static int getMaxMN(int n, int m) {
		int maxEachPrime = getMaxEachPrime(n, m);
		if (maxEachPrime == 1) {
			return n*m;
		}
		else {
			return n * (m/maxEachPrime);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		
		//大小排序
		if (n < m) {
			int t = m;
			m = n;
			n = t;
		}
		
		int maxMN = getMaxMN(n, m);
		for (int i = maxMN - 1; i > m; i--) {
			int m_count = i/m;
			int n_count = i/n;
			int flag = 0;
			for (int j = m_count + 1; j >= 0; j--) {
				for (int k = n_count + 1; k >= 0; k--) {
					if (j*m + k*n == i) {
						flag = 1; //可以被拼凑
						break;
					}
				}
				if (flag == 1) {
					break;
				}
			}
			if (flag == 0) {
				System.out.println(i);
				break;
			}
		}

	}

}
