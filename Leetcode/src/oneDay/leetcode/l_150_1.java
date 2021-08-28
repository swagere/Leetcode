package oneDay.leetcode;

import java.util.Stack;

//r
public class l_150_1 {
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
            	stack.push(oper(tokens[i], stack.pop(), stack.pop()));
            }
            else {
            	stack.add(Integer.valueOf(tokens[i]));
            }
        }
        return stack.pop();
    }

	private static int oper(String string, Integer j, Integer i) {
		int res = 0;
		switch (string) {
		case "+":
			res = i + j;
			break;
		case "-":
			res = i - j;
			break;
		case "*":
			res = i * j;
			break;
		case "/":
			res = i / j;
			break;
		default:
			break;
		}
		return res;
	}

	public static void main(String[] args) {
//		String[] tokens = {"2","1","+","3","*"};
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(evalRPN(tokens));
	}

}
