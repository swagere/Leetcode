package Code;

import java.util.Scanner;

public class M2311 {
	
	public static double Fibonacci(double l) {
		if (l < 3) {
			return 1;
		}
		return Fibonacci(l - 1) + Fibonacci(l - 2);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double n = in.nextLong();
		if (n < 20) {

			double n_1 = Fibonacci(n + 1);
			double n_2 = Fibonacci(n);

			System.out.printf("%.8f", (double)n_2 / (double)n_1);
		}
		else {
			System.out.println(0.61803399);
		}
	}

}
