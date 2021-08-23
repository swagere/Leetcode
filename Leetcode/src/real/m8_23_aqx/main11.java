package real.m8_23_aqx;

import java.util.Arrays;

//气人！！！！！！
public class main11 {

	public static int[] getFraction (float a) {
		//先算出a的位数
		float min = Float.MAX_VALUE;
		int x = 1;
		int	y = 1;
        for (int i = 1; i <= 200; i++) {
        	for (int j = 1; j <= 200 ; j++) {
        		if (Math.abs((float)i / (float)j - a) < min) {
        			min = Math.abs((float)i / (float)j - a);
        			x = i;
        			y = j;
        		}
        	}
        }
        return new int[] {x,y};
    }
	
	
	public static void main(String[] args) {
//		float a = (float) 0.333333333;
		float a = (float) 0.1415926535898;
		System.out.println(Arrays.toString(getFraction(a)));
	}

}
