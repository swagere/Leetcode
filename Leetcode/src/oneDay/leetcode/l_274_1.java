package oneDay.leetcode;

import java.util.Arrays;

//r
//从小到大
public class l_274_1 {

	public static void main(String[] args) {
		int[] citations = {3,0,6,1,5};
		System.out.println(hIndex(citations));
	}
	
	public static int hIndex(int[] citations) {
		Arrays.sort(citations);
		int i = citations.length - 1;
		for (; i >= 0; i--) {
			if (citations[i] < citations.length - i) {
				break;
			}
		}
		
		return citations.length - i - 1;
    }
}
