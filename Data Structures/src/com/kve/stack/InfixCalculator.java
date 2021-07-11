package com.kve.stack;

//中缀表达式解决
//int char可以相互转化
//用char直接存成int时，若是数字则要减去ASCII码（-48），如要存'8'，则需'8'-48

//+-*/
//多位运算
//()

public class InfixCalculator {
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
		if (((a == '*' || a == '/') && (b.equals("+") || b.equals("-"))) || a == '(' || b.equals("(")) {
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
			if (isOper(cur)) {
				//如果是运算符
				
				//如果是)符号
				if (cur == ')') {
					//则计算括号中的
					while (!operStack.getPop().equals("(")) {
						String oper = operStack.pop();
						String num1 = numStack.pop();
						String num2 = numStack.pop();
						
						double res = calculatorSingle(num1, num2, oper);
						numStack.push(String.valueOf(res));
					}
					operStack.pop(); //将(出栈
					continue;
				}
				
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
			else {
				//如果不是运算符 则扫描全部的数字 保存多位数
				String num = "";
				while (i < str.length() && !isOper(str.charAt(i))) {
					num = num + str.charAt(i);
					i++;
				}
				i--;
				numStack.push(num);
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

	private static boolean isOper(char cur) {
		if (cur == '+' || cur == '-' || cur == '*' || cur == '/' || cur == '(' || cur == ')') {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String str = "(6+3*3)*3-10";
		System.out.println(calculator(str));
		

	}

}
