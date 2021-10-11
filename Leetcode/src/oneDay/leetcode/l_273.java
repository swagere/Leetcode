package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

public class l_273 {
	public static String numberToWords(int num) {
		String[] s = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] ss = {"", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
		String[] sss = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String[] ssss = {"", "", "hundred", "Thousand", "",  "Million", ""};
		List<Integer> single = new ArrayList<>();
        int temp = num;
        while (temp > 9) {
        	single.add(temp % 10);
        	temp /= 10;
        }
        single.add(temp);
        
        int n = 1;
        String res = "";
        while (single.size() > 0) {
        	if (n == 1) {
        		if (single.size() > 1 && single.get(1) == 1) {
        			res = ss[Integer.valueOf(single.get(1) + "" + single.get(0))] + " " + res;
        			single.remove(0);
        			single.remove(0);
        			n += 2;
        		}
        		else {
        			res = s[single.get(0)] + " " + res;
        			single.remove(0);
        			n += 1;
        		}
        	}
        	else if (n == 2){
        		res = sss[single.get(0)] + " " + res;
        		single.remove(0);
        		n += 1;
        	}
        	else {
        		single.remove(0);
        	}
        	
        }
        
        return res;
    }

	public static void main(String[] args) {
		int num = 1234567;
		System.out.println(numberToWords(num));

	}

}
