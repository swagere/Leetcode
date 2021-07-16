package oneDay.offer;

//r
//Ò»ÑÛËã·¨
public class o_53_1 {
	public static int search(int[] nums, int target) {
        int count = 0;
        for (int i : nums) {
            if (i == target) {
                count++;
            } 
            else if (i > target) {
                break;
            }
        }
        return count;
    }

	public static void main(String[] args) {
		int[] nums = {5,7,7,8,8,10};
		System.out.println(search(nums, 8));
	}

}
