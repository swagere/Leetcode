package Code;

import java.util.Scanner;

public class M1461 {
	
	public static String getNext(String res,int index, int n) {
		res = res + (char)('A' + index) + res;
		index++;
		if (index == n) {
			return res;
		}
		return getNext(res, index, n);
				
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		String res = getNext("", 0, n);
		System.out.println(res);

	}

}
