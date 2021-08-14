package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//r
//计数类模拟题
public class l_233_2 {
	public static int countDigitOne(int n) {
		int temp = n;
		List<Integer> num = new ArrayList<Integer>();
		while (temp > 9) {
			num.add(temp % 10);
			temp = temp / 10;
		}
		num.add(temp % 10);


		int count = 0;
		//遍历：abcde
		for (int i = 0; i < num.size(); i++) {
			//ab=高位 de=低位
			int ab = (int) (n / Math.pow(10, i + 1));
			int de = (int) (n % Math.pow(10, i));
			
			if (ab > 0) {
				//<ab
				count += ab * Math.pow(10, i);
			}
			
			//=ab
			if (num.get(i) == 0) {
				continue;
			}
			else if (num.get(i) == 1) {
				count += de + 1;
			}
			else {
				count += Math.pow(10, i);
			}
		}
		return count;
    }

	public static void main(String[] args) {
		int n = 0;
		System.out.println(countDigitOne(n));
	}

}
