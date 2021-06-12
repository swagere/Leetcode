package Code;

import java.util.Scanner;

public class M1431 {
	//分糖果
	public static int candy(int[] ns,int candy_count, int n) {
		int flag = 0;
		for (int i = 1; i < n; i++) {
			if (ns[i]!= ns[0]) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			return candy_count; //如果两两相等，则退出；
		}
		else {
			//如果不相等，则分糖果
//			int temp = ns[n - 1];
//			for (int i = 1; i < n; i++) {
//				ns[i] = ns[i - 1]/2 + ns[i]/2;
//			}
//			ns[0] = ns[0]/2 + temp/2;
			

			for(int i=0;i<n;i++)      //数组全部除2
            {
                ns[i]=ns[i]/2;
            }
            int t=ns[0];             //把数组第一项存起来，不然第一项会变
            for(int i=0;i<n;i++)      //让小朋友把橘子给旁边的人
            {
                if(i+1<n)
                	ns[i]=ns[i]+ns[i+1];
                 
                if(i==n-1)
                {
                	ns[i]=ns[i]+t;
                }
                 
            }
			
			
			
			//此时再判断是否相等
			flag = 0;
			for (int i : ns) {
				if (i != ns[0]) {
					flag = 1;
				}
			}
			if (flag == 0) {
				return candy_count; //如果两两相等，则退出；
			}
			
			//老师给糖果
			for (int i = 0; i < n; i++) {
				if (ns[i]%2 != 0) {
					ns[i] = ns[i] + 1;
					candy_count++;
				}
			}
			return candy(ns, candy_count, n);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] ns = new int[n];
		for (int i = 0; i < n; i++) {
			ns[i] = scanner.nextInt();
		}
		int candy_count = 0;
		candy_count = candy(ns, candy_count, n);
		System.out.println(candy_count);
	}

}
