package real.m10_13_qner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {
	public static String reSort(String str) {
		List<C> res = new ArrayList<>();
		for (char c : str.toCharArray()) {
			C cc = new C(c);
			for (int i = 0; i < res.size(); i++) {
				if (res.get(i).name == c) {
					cc = res.get(i);
					res.remove(i);
					break;
				}
			}
			cc.count += 1;
			res.add(cc);
		}
		
		Collections.sort(res);
		
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < res.size(); i++) {
			int n = res.get(i).count;
			char temp = res.get(i).name;
			for (int j = 0; j < n; j++) {
				s.append(temp);
			}
		}
		return s.toString();
	}

	public static void main(String[] args) {
		String str = "baAbb";
		System.out.println(reSort(str));
	}

}

class C implements Comparable<C>{
	char name;
	int count;
	@Override
	public int compareTo(C o) {
		if (o.count - this.count == 0) {
			return this.name - o.name;
		}
		return o.count - this.count;
	}
	
	public C(char name) {
		this.name = name;
		count = 0;
	}
	
	@Override
	public String toString() {
		return this.name + ":" + this.count;
	}
}
