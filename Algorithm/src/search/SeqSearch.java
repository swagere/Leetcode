package search;

public class SeqSearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,2};

		int res = seqSearch(nums, 8);
		if (res == -1) {
			System.out.println("没有找到此元素");
		}
		else {
			System.out.println(res);
		}
	}

	//线性查找
	//找到一个就返回 返回值为下标
	private static int seqSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (i == target) {
				return i;
			}
		}
		return -1;
	}

}
