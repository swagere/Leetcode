package Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class M1454 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] list = new int[n];
		
		for (int i = 0; i < n; i++) {
			list[i] = scanner.nextInt();
		}
		 
		int ill = list[0];
		
		ArrayList<Integer> index = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			index.add(list[i]);
		}
		
		Set<Integer> flag = new HashSet<Integer>();
		flag.add(index.indexOf(ill)); 
		
		int count = 0;
		
		//模拟爬行
		while (count < n) {
			Set s = new HashSet();
			for (int i = 0; i < index.size(); i++) {
				for (int j = i + 1; j < index.size(); j++) {
					if (Math.abs(index.get(i)) > 0 && Math.abs(index.get(i)) < 100) {
						if ((index.get(j) + index.get(i) == -2 || index.get(j) + index.get(i) == -1) && !s.contains(i) && !s.contains(j)) {
							if (flag.contains(i)) {
								flag.add(j);
							}else if (flag.contains(j)) {
								flag.add(i);
							}
							
							//调头
							index.set(i, -1 * index.get(i));
							index.set(j, -1 * index.get(j));
							s.add(i);
							s.add(j);
						}
					}
				}
			}
			
			for (int i = 0; i < index.size(); i++) {
				if (Math.abs(index.get(i)) > 0 && Math.abs(index.get(i)) < 100) {
					int cur = i;
					if (index.contains(-(index.get(i)+1))) {
						while (index.indexOf(index.get(cur)) != cur || index.lastIndexOf(index.get(cur)) != cur) {
							if (cur == 0) {
								if (!index.contains(index.get(cur))) {
									break;
								}
							}
							
							if (index.indexOf(index.get(cur)) != cur) {
								index.set(cur, index.get(cur) - 1);
							}
							else if (index.lastIndexOf(index.get(cur)) != cur) {
								index.set(cur, index.get(cur) - 1);
							}
							cur--;
							
						}
					}
					else {
						index.set(i, index.get(i)+1);
					}
				}
				if (index.get(i) == 100 || index.get(i) == 0) {
					index.set(i, 1000);
					count++;
				}
			}
			
		}
		System.out.println(flag.size());
	}
}
