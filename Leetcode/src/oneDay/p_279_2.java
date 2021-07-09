package oneDay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//r
public class p_279_2 {
	static int[] array;
	
	//��ͨ�ݹ� + ���仯�������洢�Ѽ������ֵ  + min��ʹ��
	public static int numSquares(int n) {
		array = new int[n + 1]; //ȫ����ʼ��Ϊ0
		return f(n);
	}
	
	public static int f(int n) {
		if (n == 0) {
			 return n;
		 }else if (array[n] != 0) {
			 return array[n];
		 }
		 
		 //���nΪƽ����
		 int temp = (int)Math.sqrt(n);
		 if (temp * temp == n) {
			 return 1;
		 }
		 
		 List<Integer> res  = new ArrayList<>();
		 for (int i = 1; i < Math.sqrt(n); i++) {
			 res.add(f(i * i) + f(n - i * i));
		 }
		 
		//�ҵ�res����С��
		 int min = res.get(0);
		 for (int i : res) {
			 if (i < min) {
				 min = i;
			 }
		 }
		 
		 return array[n];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println(numSquares(n));
	}
	
	
}
