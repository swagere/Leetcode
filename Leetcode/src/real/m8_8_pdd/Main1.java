package real.m8_8_pdd;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][3];
        for (int i = 0; i < n; i++) {
        	nums[i][0] = sc.nextInt();
        	nums[i][1] = sc.nextInt();
        	nums[i][2] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
        	int count = 0;
        	if (Math.abs(nums[i][0]) < nums[i][2]) {
        		count += 2;
        	}
        	else if (Math.abs(nums[i][0]) == nums[i][2]) {
        		count += 1;
        	}
        	
        	if (Math.abs(nums[i][1]) < nums[i][2]) {
        		count += 2;
        	}
        	else if (Math.abs(nums[i][1]) == nums[i][2]) {
        		count += 1;
        	}
        	
        	//如果和零点相交 则减掉一个
        	if (nums[i][0]*nums[i][0] + nums[i][1]*nums[i][1] == nums[i][2]*nums[i][2]) {
        		count -= 1;
        	}
        	
        	System.out.println(count);
        }


	}

}
