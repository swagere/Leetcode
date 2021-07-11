package com.kve.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//后缀表达式解决：中缀=》后缀
public class SuffixCalculator {

	public static void main(String[] args) {
		String expresstion = "6+(3+16/4)*3+2";
		
		//先由普通的中缀表达式得出后缀表达式
		List<String> suffixExpression = parseSuffixExpression(expresstion);
		System.out.println(suffixExpression);
		
		//计算出结果
		String res = calculator(suffixExpression);
		System.out.println(res);
	}

	//计算得结果
	private static String calculator(List<String> suffixExpression) {
		//从左到右扫描 遇到数字则进栈 遇到符合则拿两个数字出来运算
		Stack<String> res = new Stack<>();
		for (String s : suffixExpression) {
			if (s.matches("\\d+")) {
				//如果是数字则直接入栈
				res.push(s);
			}
			else {
				//如果是操作符 则弹出两个数字运算
				System.out.println(s);
				double num1 = Double.valueOf(res.pop());
				double num2 = Double.valueOf(res.pop());
				double res1 = 0;
				
				switch (s) {
				case "+":
					res1 = num1 + num2;
					break;
				case "-":
					res1 = num2 - num1;
					break;
				case "*":
					res1 = num2 * num1;
					break;
				case "/":
					res1 = num2 / num1;
					break;
				default:
					break;
				}
				
				res.push(String.valueOf(res1));
			}
		}
		return res.pop();
	}

	//转换成后缀表达式list
	private static List<String> parseSuffixExpression(String expresstion) {
		Stack<Character> oper = new Stack<>();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < expresstion.length(); i++) {
			char c = expresstion.charAt(i);
			if (isDigit(c)) {
				//如果是数字 先得到完整的
				String num = "" + c;
				while (i + 1 < expresstion.length() && isDigit(expresstion.charAt(i + 1))) {
					num = num + expresstion.charAt(i + 1);
					i++;
				}
				
				//得到一个数字 入list
				res.add(num);
			} else {
				//如果是字符
				if (c == '(') {
					//如果是左括号 直接入栈
					oper.push(c);
				}
				else if (c == ')') {
					//如果是右括号 则出栈到list 到)为止
					while (oper.peek() != '(') {
						res.add(String.valueOf(oper.pop()));
					}
					
					oper.pop(); //弹出)
				}
				else {
					//如果是加减乘除
					if (oper.isEmpty()) {
						//如果符号栈为空 则直接进栈
						oper.push(c);
					}
					else {
						//比较栈顶元素优先级
						//若优先级大则直接入栈 若栈顶元素优先级大则栈顶元素出栈到list
						while (getValue(c) < getValue(oper.peek())) {
							res.add(String.valueOf(oper.pop()));
						}
						
						oper.push(c);
					}
				}
			}
		}
		
		//将栈中所有元素依次放入list
		while (!oper.isEmpty()) {
			res.add(String.valueOf(oper.pop()));
		}
		
		return res;
	}

	//判断是否为数字
	private static boolean isDigit(char c) {
		if (c - '0' >= 0 && c - '9' <= 0) {
			return true;
		}
		return false;
	}
	
	//获得符号优先级大小
	private static int getValue(char c) {
		switch (c) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		default:
			break;
		}
		return 0;
	}
}
