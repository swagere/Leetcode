package Code;

import java.awt.Window.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class M1083 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuffer a = new StringBuffer();
		while(scanner.hasNextLine()) {
			a.append(scanner.nextLine() + " ");
		}
	
		String str = a.toString();
		
		str.replace("\n", " ");
		str.replace("\t", " ");
		String[] string = str.split(" ");
		
		for (String s : string) {
			int ss = Integer.valueOf(s);
			char sss = (char)ss;
			System.out.print(sss);
		}
	}

}
