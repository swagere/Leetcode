package oneDay.leetcode;

//r
//while + for
public class l_551_1 {
	public static boolean checkRecord(String s) {
        int acount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                acount += 1;
                if (acount == 2) {
                    return false;
                }
            }
            else if (s.charAt(i) == 'L') {
                int temp = i;
                while (i < s.length() && s.charAt(i) == 'L') {
                    if (i - temp == 2) {
                        return false;
                    } 
                    i++;
                }
                i--;
            }
        }

        return true;
    }

	public static void main(String[] args) {
		String s = "ALAPPL";
		System.out.println(checkRecord(s));

	}

}
