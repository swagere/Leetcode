package kmp;

import java.util.Arrays;

//kmp�㷨
public class KMP {

	public static void main(String[] args) {
		String s1 = "BBC ABCDAB ABCDABCDABDE";
		String s2 = "ABCDABD";
		
		System.out.println(kmp(s1, s2));

	}

	private static int kmp(String s1, String s2) {
		//�ȵó�next�� ����ƥ���
		int[] next = getNext(s2);
		
		System.out.println(Arrays.toString(next));
		//����next����������
		int i = 0;
		int j = 0;
		while (i < s1.length()) {
			//�ص���һ����ƥ���λ��
			while (j > 0 && s1.charAt(i) != s2.charAt(j)) {
				j = next[j - 1];
			}
			
			//�ж��Ƿ����
			if (s1.charAt(i) == s2.charAt(j)) {
				j++;
			}
			
			if (j == s2.length()) {
				return i - j + 1;
			}
			i++;
		}
		
		return -1;
	}

	//�õ�����ƥ���
	private static int[] getNext(String s) {
		int[] next = new int[s.length()];
		
		int i = 1;
		int j = 0;
		next[0] = 0;
		while (i < s.length()) {
			
			//���������������ƥ��ֵ֮ǰ��ֵ��ֱ���ҵ����
			//����ǰ�� ���ҵ��ϴ���ȵĵ�
			while (j > 0 && s.charAt(i) != s.charAt(j)) {
				j = next[j - 1];
			}
			
			//Ȼ���ٱȽ�
			if (s.charAt(i) == s.charAt(j)) {
				//��������ֱ��������Ѱ��
				j++;
			}
			
			next[i] = j;
			i++;
		}
		return next;
	}

}
