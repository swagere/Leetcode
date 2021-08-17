package oneDay.leetcode;

//r
//for（清零思想
public class l_551_2 {
	public static boolean checkRecord(String s) {
        int acount = 0;
        int lcount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
            	lcount = 0;
                acount += 1;
                if (acount == 2) {
                    return false;
                }
            }
            else if (s.charAt(i) == 'L') {
               lcount += 1;
               if (lcount == 3) {
            	   return false;
               }
            }
            else {
            	lcount = 0;
            }
        }

        return true;
    }

	public static void main(String[] args) {
		String s = "ALAPPL";
		System.out.println(checkRecord(s));

	}

}
