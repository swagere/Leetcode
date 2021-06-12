package Code;

import java.util.Scanner;

public class M1470 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		
		int hour = t / 60 / 60;
		int min = (t - hour * 60 * 60) / 60;
		int sec = t - hour * 60 * 60 - min * 60;

		System.out.println(hour + ":" + min + ":" + sec);
	}

}
