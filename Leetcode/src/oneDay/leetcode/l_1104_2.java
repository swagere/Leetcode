package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//r
//利用没有翻转前的数组，算出路径，再翻转
public class l_1104_2 {
	public static List<Integer> pathInZigZagTree(int label) {
		List<Integer> res = new ArrayList<>();
		
		//先得到层数 判断是否要翻转
		int height = getHeight(label);
		if (height % 2 != 0) {
			//翻转
			label = (int) (3 * Math.pow(2, height) - 1 - label);
		}
		
		//得到路径
		int temp = label;
		res.add(temp);
		while (temp != 1) {
			if (temp % 2 == 0) {
				temp = temp / 2;
				
			}
			else {
				temp = (temp - 1) / 2;
				
			}
			res.add(0, temp);
		}
		
		//翻转路径
		for (int i = 0; i <= height; i++) {
			if (i % 2 != 0) {
				res.set(i, (int) (3 * Math.pow(2, getHeight(res.get(i))) - 1 - res.get(i)));
			}
		}
		
		
		return res;
    }

	public static int getHeight(int label) {
		int i = 0;
		int sum = 0;
        while (true) {
        	if (label > sum) {
        		sum += Math.pow(2, i);
        		i++;
        	}
        	else {
        		break;
        	}
        }
        
        return i - 1;
	}
	
	

	public static void main(String[] args) {
		int label = 14;
		
		System.out.println(pathInZigZagTree(label));
	}

}
