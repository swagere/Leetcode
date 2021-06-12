package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M1093 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		
		String[] words = str.split(" ");
		List<String> res = new ArrayList<String>();
		for (String word : words) {
			String temp = new String();
			for (int i = word.length() - 1; i >= 0; i--) {
				temp = temp + word.charAt(i);
			}
			res.add(temp);
		}
		for (int i = res.size() - 1; i >= 0; i--) {
			System.out.print(res.get(i));
			if ( i != 0) {
				System.out.print(" ");
			}
		}

	}

}
