package real.m4_14_blf;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.nextLine();
		MyMap map = new MyMap(10000);
		
		
		String[] input = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextLine();
		}
		
		for (int i = 0; i < n; i++) {
			String s = input[i];
			char oper = s.charAt(0);
			s = s.substring(1);
			String[] nums = s.split(",");
			if (oper == '>') {
				map.put(nums[0], nums[1]);
			}
			else if (oper == '<') {
				System.out.println(map.get(nums[0]));
			}
			else if (oper == 'X') {
				map.remove(nums[0]);
			}
		}
	}

}

class MyMap {
	Object[] key;
	int size;
	Object[] value;
	
	public MyMap(int size) {
		this.size = size;
		key = new Object[size];
		value = new Object[size];
	}
	
	public void put(Object k, Object v) {
		int index = k.hashCode() % size;
		key[index] = k;
		value[index] = v;
	}
	
	public Object get(Object k) {
		int index = k.hashCode() % size;
		Object v = value[index];
		if (v == null) {
			return "_EMPTY_";
		}
		return v;
	}
	
	public void remove(Object k) {
		int index = k.hashCode() % size;
		key[index] = null;
		value[index] = null;
	}
}
