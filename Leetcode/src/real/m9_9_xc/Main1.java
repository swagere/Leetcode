package real.m9_9_xc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main1 {
	static List<String> catalogue = new ArrayList<String>();
	public static void simulation(int n,String[] strs) {
		for (int i = 0; i < n; i++) {
			if (strs[i].equals("pwd")) {
				//Êä³ö
				if (catalogue.size() == 0) {
					System.out.println("\\");
				}
				else {
					for (int j = 0; j < catalogue.size(); j++) {
						System.out.print("\\" + catalogue.get(j));
					}
					System.out.println();
				}
			}
			else {
				String aim = strs[i].substring(3);
				if (aim.equals("..") && catalogue.size() > 0) {
					catalogue.remove(catalogue.size() - 1);
				}
				else if (!aim.equals("..")){
					catalogue.add(aim);
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		String[] strs = new String[n];
		for (int i = 0; i < n; i++) {
			strs[i] = in.nextLine();
		}
		
		simulation(n, strs);
	}

}
