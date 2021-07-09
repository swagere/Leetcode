package com.kve.stack;

//int char�����໥ת��
//��charֱ�Ӵ��intʱ������������Ҫ��ȥASCII�루-48������Ҫ��'8'������'8'-48

public class calculator {
	//���μ��� 
	//����:��������һ��������
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
	
	//���ȼ��Ƿ����
	public static boolean biggerthan(char a, String b) {
		if ((a == '*' || a == '/') && (b.equals("+") || b.equals("-"))) {
			return true;
		}
		return false;
	}
	
	//����������
	public static String calculator(String str) {
		//��ʼ��ջ
		LinkedListStack numStack = new LinkedListStack();
		LinkedListStack operStack = new LinkedListStack();
		
		//������������ֿ�
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur - '0' >= 0 && cur - '9' <= 0) {
				//���ֽ�ջ
				numStack.push(String.valueOf(cur));
			}
			else {
				//����������
				//���ջΪ�� �� ��������ȼ�����ջ��Ԫ�����ȼ� ��ֱ�ӽ�ջ
				if (operStack.isEmpty() || biggerthan(cur, operStack.getPop())) {
					operStack.push(String.valueOf(cur));
				}
				else {
					//ѹ��ǰһ����������������� ����֮���µ����ֺ��µ��������ջ
					String oper = operStack.pop();
					String num1 = numStack.pop();
					String num2 = numStack.pop();
					
					double res = calculatorSingle(num1, num2, oper);
					
					numStack.push(String.valueOf(res));
					operStack.push(String.valueOf(cur));
					
				}
			}
		}
		
		//���� 
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
