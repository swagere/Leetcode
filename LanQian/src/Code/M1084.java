package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 1. ��������2��ʼ��i������%С��i��������n��ֹ
 * 2. ����������շת����������Ժ�С��������֪�����Ƿ��أ����ȫ��������˵��������
 * 3. ����������n���������ķ������ҳ�С�ڵ���n��ƽ���ڵ������������ų�����������/list��
 * @author 12505
 *
 */

public class M1084 {
	//�õ��������
	public static int getGreatestCommonFactor(int n, int m) {
		//swap
		if (n < m) {
			int t = m;
			m = n;
			n = t;
		}
		
		//շת�����
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
			
			
			//շת������������ǲ�������������������
			int greatestCommonFactor = getGreatestCommonFactor(s, i); //�õ��������
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
			for (int i = 3; i < n; i = i + 2) { //0-n����������
				Boolean isPrimeNumber = isPrimeNumber(i, primeNumbers);
				if (isPrimeNumber == true) {
					primeNumbers.add(i);
					System.out.println(i);
				}
			}
		}
	}

}
