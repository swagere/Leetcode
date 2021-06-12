package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M2309 {
	static boolean isZimu(char a) {
		if (a - 'a' >= 0 && 'z' - a >= 0) {
			return true;
		}
		else if (a - 'A' >= 0 && 'Z' - a >= 0) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		in.nextLine();
		String s = in.nextLine();
		List<Integer> index_a = new ArrayList<Integer>();
		List<Integer> index_b = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'A' && ( i == 0 || (i != 0 && !isZimu(s.charAt(i - 1))))) {
				i++;
				if (i < s.length() && s.charAt(i) == 'l') {
					i++;
					if (i < s.length() && s.charAt(i) == 'i') {
						i++;
						if (i < s.length() && s.charAt(i) == 'c') {
							i++;
							if (i < s.length() && s.charAt(i) == 'e') {
								i++;
								if (i < s.length() && !isZimu(s.charAt(i))) {
									index_a.add(i - 5);
								}
								else if (i == s.length()) {
									index_a.add(i - 5);
								}
							}
						}
						
					}
				}
			}
			else if (s.charAt(i) == 'B' && ( i == 0 || (i != 0 && !isZimu(s.charAt(i - 1))))) {
				i++;
				if (i < s.length() && s.charAt(i) == 'o') {
					i++;
					if (i < s.length() && s.charAt(i) == 'b') {
						i++;
						if (i < s.length() && !isZimu(s.charAt(i))) {
							index_b.add(i - 3);
						}
						else if (i == s.length()) {
							index_b.add(i - 3);
						}
					}
				}
			}
		}
		
		long count = 0;
		
		for (int i = 0; i < index_a.size(); i++) {
			for (int j = 0; j < index_b.size(); j++) {
				if (index_a.get(i) - index_b.get(j) > 0 && index_a.get(i) - index_b.get(j) <= k + 3) {
					while (j < index_b.size() && index_b.get(j) - index_a.get(i) <= k + 5) {
						count++;
						j++;
					}
					break;
				}
				else if (index_b.get(j) - index_a.get(i) > 0){
					while (j < index_b.size() && index_b.get(j) - index_a.get(i) <= k + 5){
						count++;
						j++;
					}
					break;
				}
			}
		
		
		}
		System.out.println(count);
	}

}
