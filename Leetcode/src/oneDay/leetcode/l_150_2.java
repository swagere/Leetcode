package oneDay.leetcode;

import java.util.Arrays;

//r
public class l_150_2 {
	public static int evalRPN(String[] tokens) {
        for (int i = 0; i < tokens.length; i++) {
            if (isOper(tokens[i])) {
                int temp = i;
                int[] nums = new int[2];
                int index = 0;
                while (temp >= 0 && index < 2) {
                    if (!isOper(tokens[temp])) {
                        nums[index] = Integer.valueOf(tokens[temp]);
                        tokens[temp] = "";
                        index += 1;
                    }
                    temp --;
                }
                
                tokens[temp + 1] = String.valueOf(oper(tokens[i], nums[0], nums[1]));
                tokens[i] = "";
            }
        }
//        System.out.println(Arrays.toString(tokens));
        return Integer.valueOf(tokens[0]);
    }

    private static boolean isOper(String string) {
        if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/") || string.equals("")) {
            return true;
        }
        return false;
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
//		String[] tokens = {"4","13","5","/","+"};
		System.out.println(evalRPN(tokens));
	}

}
