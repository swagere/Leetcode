package objectoriented;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortImplementDemo {
	public static void main(String[] args) {
		//类实现接口
		Cla1 c1 = new Cla1('a',1);
		Cla1 c2 = new Cla1('a',5);
		Cla1 c3 = new Cla1('a',3);
		List<Cla1> cla1 = new ArrayList<>();
		cla1.add(c1);
		cla1.add(c2);
		cla1.add(c3);
		Collections.sort(cla1);
		System.out.println(cla1);
		
		//匿名类实现接口
		Cla2 cc1 = new Cla2('a',1);
		Cla2 cc2 = new Cla2('a',5);
		Cla2 cc3 = new Cla2('a',3);
		List<Cla2> cla2 = new ArrayList<>();
		cla2.add(cc1);
		cla2.add(cc2);
		cla2.add(cc3);
		Collections.sort(cla2, new Comparator<Cla2>() {

			@Override
			public int compare(Cla2 o1, Cla2 o2) {
				return o1.value - o2.value;
			}
		});
		System.out.println(cla2);
	}
}

class Cla1 implements Comparable<Cla1>{
	char name;
	int value;
	public Cla1(char name, int value) {
		this.name = name;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Cla1 [name=" + name + ", value=" + value + "]";
	}
	@Override
	public int compareTo(Cla1 o) {
		return this.value - o.value;
	}
}

class Cla2 {
	char name;
	int value;
	public Cla2(char name, int value) {
		this.name = name;
		this.value = value;
	}
	@Override
	public String toString() {
		return "Cla2 [name=" + name + ", value=" + value + "]";
	}
}