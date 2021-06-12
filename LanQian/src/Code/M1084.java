package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. 常见：从2开始数i，依次%小于i的数，到n截止
 * 2. 用拉格朗日辗转相除法，测试和小于它的已知素数是否互素，如果全部互素则说明是素数
 * 3. 近世代数求n以内素数的方法：找出小于等与n的平方内的素数，用其排除合数（数组/list）
 * @author 12505
 *
 */

public class M1084 {
	//得到最大公因数
	public static int getGreatestCommonFactor(int n, int m) {
		//swap
		if (n < m) {
			int t = m;
			m = n;
			n = t;
		}
		
		//辗转相除法
		int r = n % m;
		n = m;
		m = r;
		while (r != 0 ) {
			r = n % m;
			n = m;
			m = r;
		}
		return n;
	}
	
	public static Boolean isPrimeNumber(int i, List<Integer> primeNumbers) {
		for (int s : primeNumbers) {
			
			
			//辗转相除法：计算是不是与所有素数都互素
			int greatestCommonFactor = getGreatestCommonFactor(s, i); //得到最大公因数
			if (greatestCommonFactor != 1) {
				return false;
			}
		}
		return true;
		
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		List<Integer> primeNumbers = new ArrayList<Integer>();
		primeNumbers.add(2);
		if (n <= 1) {
			System.out.println(" ");
		}
		if (n == 2) {
			System.out.println(2);
		}
		else {
			System.out.println(2);
			for (int i = 3; i < n; i = i + 2) { //0-n中所有素数
				Boolean isPrimeNumber = isPrimeNumber(i, primeNumbers);
				if (isPrimeNumber == true) {
					primeNumbers.add(i);
					System.out.println(i);
				}
			}
		}
	}

}
