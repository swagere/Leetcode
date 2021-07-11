package com.kve.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//��׺���ʽ�������׺=����׺
public class SuffixCalculator {

	public static void main(String[] args) {
		String expresstion = "6+(3+16/4)*3+2";
		
		//������ͨ����׺���ʽ�ó���׺���ʽ
		List<String> suffixExpression = parseSuffixExpression(expresstion);
		System.out.println(suffixExpression);
		
		//��������
		String res = calculator(suffixExpression);
		System.out.println(res);
	}

	//����ý��
	private static String calculator(List<String> suffixExpression) {
		//������ɨ�� �����������ջ �������������������ֳ�������
		Stack<String> res = new Stack<>();
		for (String s : suffixExpression) {
			if (s.matches("\\d+")) {
				//�����������ֱ����ջ
				res.push(s);
			}
			else {
				//����ǲ����� �򵯳�������������
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

	//ת���ɺ�׺���ʽlist
	private static List<String> parseSuffixExpression(String expresstion) {
		Stack<Character> oper = new Stack<>();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < expresstion.length(); i++) {
			char c = expresstion.charAt(i);
			if (isDigit(c)) {
				//��������� �ȵõ�������
				String num = "" + c;
				while (i + 1 < expresstion.length() && isDigit(expresstion.charAt(i + 1))) {
					num = num + expresstion.charAt(i + 1);
					i++;
				}
				
				//�õ�һ������ ��list
				res.add(num);
			} else {
				//������ַ�
				if (c == '(') {
					//����������� ֱ����ջ
					oper.push(c);
				}
				else if (c == ')') {
					//����������� ���ջ��list ��)Ϊֹ
					while (oper.peek() != '(') {
						res.add(String.valueOf(oper.pop()));
					}
					
					oper.pop(); //����)
				}
				else {
					//����ǼӼ��˳�
					if (oper.isEmpty()) {
						//�������ջΪ�� ��ֱ�ӽ�ջ
						oper.push(c);
					}
					else {
						//�Ƚ�ջ��Ԫ�����ȼ�
						//�����ȼ�����ֱ����ջ ��ջ��Ԫ�����ȼ�����ջ��Ԫ�س�ջ��list
						while (getValue(c) < getValue(oper.peek())) {
							res.add(String.valueOf(oper.pop()));
						}
						
						oper.push(c);
					}
				}
			}
		}
		
		//��ջ������Ԫ�����η���list
		while (!oper.isEmpty()) {
			res.add(String.valueOf(oper.pop()));
		}
		
		return res;
	}

	//�ж��Ƿ�Ϊ����
	private static boolean isDigit(char c) {
		if (c - '0' >= 0 && c - '9' <= 0) {
			return true;
		}
		return false;
	}
	
	//��÷������ȼ���С
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
