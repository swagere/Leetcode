package com.kve.stack;

//int char可以相互转化
//用char直接存成int时，若是数字则要减去ASCII码（-48），如要存'8'，则需'8'-48

public class calculator {
	//单次计算 
	//输入:两个数和一个操作符
	public static double calculatorSingle(String num2, String num1, String oper) {
		double n1 = Double.valueOf(num1);
		double n2 = Double.valueOf(num2);
		switch (oper) {
		case "+":
			return n1 + n2;
		case "-":
			return n1 - n2;
		case "*":
			return n1 * n2;
		}
		return n1 / n2;
	}
	
	//优先级是否大于
	public static boolean biggerthan(char a, String b) {
		if ((a == '*' || a == '/') && (b.equals("+") || b.equals("-"))) {
			return true;
		}
		return false;
	}
	
	//函数主方法
	public static String calculator(String str) {
		//初始化栈
		LinkedListStack numStack = new LinkedListStack();
		LinkedListStack operStack = new LinkedListStack();
		
		//将数和运算符分开
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur - '0' >= 0 && cur - '9' <= 0) {
				//数字进栈
				numStack.push(String.valueOf(cur));
			}
			else {
				//如果是运算符
				//如果栈为空 或 运算符优先级大于栈顶元素优先级 则直接进栈
				if (operStack.isEmpty() || biggerthan(cur, operStack.getPop())) {
					operStack.push(String.valueOf(cur));
				}
				else {
					//压出前一个运算符和两个数字 运算之后新的数字和新的运算符入栈
					String oper = operStack.pop();
					String num1 = numStack.pop();
					String num2 = numStack.pop();
					
					double res = calculatorSingle(num1, num2, oper);
					
					numStack.push(String.valueOf(res));
					operStack.push(String.valueOf(cur));
					
				}
			}
		}
		
		//计算 
		while (numStack.GthanOne() && !operStack.isEmpty()) {
			String oper = operStack.pop();
			String num1 = numStack.pop();
			String num2 = numStack.pop();
			
			double res = calculatorSingle(num1, num2, oper);
			
			numStack.push(String.valueOf(res));
		}
		
		return numStack.pop();
	}

	public static void main(String[] args) {
		String str = "6+3*3-1";
		System.out.println(calculator(str));
		

	}

}
