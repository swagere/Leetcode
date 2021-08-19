package oneDay.leetcode;

//r
//双指针
public class l_345 {
	public static String reverseVowels(String s) {
		char[] str = s.toCharArray();
        for (int i = 0, j = str.length - 1; ;) {
            while (i < j && !isVowel(str[i])) {
                i++;
            }

            while (j > i && !isVowel(str[j])) {
                j--;
            }

            if (i >= j) {
                break;
            }

            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++;
            j--;
        }
        return String.copyValueOf(str);
    }

    public static boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || 
        c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		String s = "ai";
		System.out.println(reverseVowels(s));

	}

}
