package real.m8_8_pdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String str = sc.next();

		char[] oper = str.toCharArray();
		
		int index = 0;
		List<Character> s = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			switch (oper[i]) {
			case '(':
				s.add(index, '(');
				index += 1;
				getScore(s,n);
				break;
			case ')':
				s.add(index, ')');
				index += 1;
				getScore(s,n);
				break;
			case 'L':
				if (index == 0) {
					getScore(s,n);
					continue;
				}
				index -= 1;
				getScore(s,n);
				break;
			case 'R':
				if (index == s.size()) {
					getScore(s,n);
					continue;
				}
				index += 1;
				getScore(s,n);
				break;
			case 'D':
				s.remove(index - 1);
				index -= 1;
				getScore(s,n);
				break;
			}
		}
		
		
	}
	
	public static void getScore(List<Character> s, int n) {
		//利用栈来检验
		Stack<Character> stack = new Stack<>();
		int add = 0;
		int reduce = 0;
		for (Character c : s) {
			if (c != ')') {
				stack.push(c);
			}
			
			else {
				while (stack.size() > 0 && stack.peek() != '(') {
					stack.pop();
				}
				
				if (stack.size() > 0 && stack.peek() == '(') {
					stack.pop();
					add += 1;
				}
				else {
					reduce += 1;
				}
			}
		}
		
		if (stack.size() > 0) {
			reduce += stack.size();
		}
		
		if (reduce == 0) {
			System.out.print(add);
		}
		else {
			System.out.print((reduce > 0 ? -reduce : reduce));
		}
	}
}
