package dac;

public class Hanoitower {
	static int count = 0;

	public static void main(String[] args) {
		hanoitower(5, 'A', 'B', 'C');
		System.out.println(count);
	}
	
	public static void hanoitower(int num, char a, char b, char c) {
		count++;
		if (num == 1) {
			//����������ƶ�
			System.out.println("�ƶ���" + num + "��:" + a + "->" + c);
		}
		else {
			//�����ڵ���1 ��ֳ��������֣��������һ��+���������
			//1. �ƶ���������е�B
			hanoitower(num - 1, a, c, b);
			
			//2. �ƶ��������һ��
			System.out.println("�ƶ���" + num + "��:" + a + "->" + c);
			
			//3. �ƶ����������
			hanoitower(num - 1, b, a, c);
		}
	}

}
