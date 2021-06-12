package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M1094 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		List<String> strs = new ArrayList<String>();
		while (scanner.hasNextLine()) {
			strs.add(scanner.nextLine());
		}
		for (int i = 1; i <= n; i++) {
			System.out.print(strs.get(i));
			System.out.println("\n");
		}
		for (int i = n + 1; i < strs.size(); i++) {
			String[] str = strs.get(i).split(" ");
			for (String s : str) {
				System.out.print(s);
				if (i == strs.size() - 1 && s == str[str.length - 1]) { //不能用equal，必须用等号，表明一定是最后一行最后一个，避免最后一行是D O T CPP D而到第一个D就停止的情况
					break;
				}
				System.out.println("\n");
			}
		}

	}

}
