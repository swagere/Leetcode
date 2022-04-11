package oneDay.offer;

public class o_64 {

	public static void main(String[] args) {
		System.out.println(new Solution641().sumNums(9));

	}

}

//µİ¹é
class Solution641 {
    public int sumNums(int n) {
    	boolean res = n > 1 && (n = n + sumNums(n - 1)) > 0;
		return n;
    }
}
