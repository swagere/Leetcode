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
				if (i == strs.size() - 1 && s == str[str.length - 1]) { //������equal�������õȺţ�����һ�������һ�����һ�����������һ����D O T CPP D������һ��D��ֹͣ�����
					break;
				}
				System.out.println("\n");
			}
		}

	}

}
