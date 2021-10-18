package oneDay.leetcode;

public class l_476 {
	public static int findComplement(int num) {
		String b = Integer.toBinaryString(num);
		StringBuffer res = new StringBuffer();
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == '0') {
				res.append(1);
			}
			else {
				res.append(0);
			}
		}
		
		
        return Integer.parseInt(res.toString(), 2);
    }

	public static void main(String[] args) {
		int num = 5;
		System.out.println(findComplement(num));
	}

}
