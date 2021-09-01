package oneDay.leetcode;

import java.util.Arrays;

public class l_528 {
	static float[] weight;

    @Override
	public String toString() {
		return "weight=" + Arrays.toString(weight);
	}

	public l_528(int[] w) {
        weight = new float[w.length];

        int sum = 0;
        for (int i : w) {
            sum += i;
        }

        weight[0] = (float)w[0] / sum;
        for (int i = 1; i < w.length; i++) {
            weight[i] = (float)w[i] / sum + weight[i - 1];
        }
        
    }
    
    public static int pickIndex() {
    	double rate = Math.random();
    	System.out.println(rate);
    	int i = 0;
    	for (i = 0; i < weight.length; i++) {
    		if (rate < weight[i]) {
    			break;
    		}
    	}
    	System.out.println(i);
        return i;
    }

	public static void main(String[] args) {
		int[] w = {1,2,3,4,5};
		l_528 item = new l_528(w);
		System.out.println(item.toString());
		System.out.println(pickIndex());
	}

}
