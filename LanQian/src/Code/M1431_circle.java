package Code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class M1431_circle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] ns = new int[n];
		for (int i = 0; i < n; i++) {
			ns[i] = scanner.nextInt();
		}
		int candy_count = 0;
		int flag = 0;
		for (int i = 1; i < n; i++) {
			if (ns[i] != ns[0]) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			while (flag != 0) {
				//�������ȣ�����ǹ�
//				int temp = ns[n - 1];
//				for (int i = 1; i < n; i++) {
//					ns[i] = ns[i - 1]/2 + ns[i]/2;
//				}
//				ns[0] = ns[0]/2 + temp/2;
				
				for(int i=0;i<n;i++)      //����ȫ����2
	            {
	                ns[i]=ns[i]/2;
	            }
	            int t=ns[0];             //�������һ�����������Ȼ��һ����
	            for(int i=0;i<n;i++)      //��С���Ѱ����Ӹ��Աߵ���
	            {
	                if(i+1<n)
	                	ns[i]=ns[i]+ns[i+1];
	                 
	                if(i==n-1)
	                {
	                	ns[i]=ns[i]+t;
	                }
	                 
	            }
				
				
				
				//��ʦ���ǹ�
				for (int i = 0; i < n; i++) {
					if (ns[i]%2 != 0) {
						ns[i] = ns[i] + 1;
						candy_count++;
					}
				}
				
				//��ʱ���ж��Ƿ����
				flag = 0;
				for (int i = 1; i < n; i++) {
					if (ns[i] != ns[0]) {
						flag = 1;
						break;
					}
				}
				if (flag == 0) {
					break; //���������ȣ����˳���
				}
			}
		}
		System.out.println(candy_count);
	}
}
