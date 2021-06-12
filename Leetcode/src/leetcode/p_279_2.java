package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p_279_2 {
	static int[] array;
	
	//��ͨ�ݹ� + ���仯�������洢�Ѽ������ֵ
	 public static int numSquares(int n) {
		 if (n == 0) {
			 return n;
		 }else if (array[n] != 0) {
			 return array[n];
		 }
		 
		 //���nΪƽ����
		 for (int i = 1; i <= Math.sqrt(n); i++) {
			 if (i*i == n) {
				 return 1;
			 }
		 }
		 
		 
		 List<Integer> res = new ArrayList<Integer>();
		 for (int i = 1; i <= Math.sqrt(n); i++) {
			 res.add(numSquares(i * i) + numSquares(n - i * i));
		 }

		 //�ҵ�res����С��
		 int min = res.get(0);
		 for (int i : res) {
			 if (i < min) {
				 min = i;
			 }
		 }
		 
		 array[n] = min;
		 
		 return min;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		array = new int[n + 1];
		System.out.println(numSquares(n));
	}
	
	
}
