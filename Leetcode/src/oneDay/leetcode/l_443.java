package oneDay.leetcode;


public class l_443 {
	public static int compress(char[] chars) {
        int n = 0;
        char a = chars[chars.length - 1];
        char b = chars[chars.length - 2];
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] == chars[i]) {
                int count = 1;
                while (i < chars.length && chars[i - 1] == chars[i]) {
                    i++;
                    count++;
                }
                //填入字母
                chars[n] = chars[i - 1];
                n += 1;
                
                int[] res = new int[4];
                int index = 0;
                //填入数字
                while (count > 9) {
                    res[index] = count % 10;
                    count = count / 10;
                    index += 1;
                }
                res[index] = count;
                index += 1;

                while (index > 0) {
                	index -= 1;
                    chars[n] = (char) (res[index] + '0');
                    n++;
                }
            }
            else {
                chars[n] = chars[i - 1];
                n++;
            }
        }
        
        if (a != b) {
        	chars[n] = chars[chars.length - 1];
            n++;
        }
        return n;
    }

	public static void main(String[] args) {
		char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
//		char[] chars = {'a','b','c'};
		int res = compress(chars);

		for (int i = 0; i < res; i++) {
			System.out.print(chars[i]);
		}
	}

}
