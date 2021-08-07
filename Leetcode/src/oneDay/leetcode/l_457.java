package oneDay.leetcode;


//r
//三色+深搜
public class l_457 {
	static int start = -1;
	static int end = -1;
	public static boolean circularArrayLoop(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int[] visited = new int[nums.length];
			if (!dfs(nums, i, visited)) {
				//有循环
				if (start == end) {
					continue;
				}
				
				//判断所有点的下标是否相等
				int sum = nums[end];
				boolean flag = true;
				while (start != end) {
					if (nums[start] * sum < 0) {
						flag = false;
						break;
					}
					start = ((nums[start] + start) % nums.length + nums.length) % nums.length;
				}
				
				if (flag == true) {
					return true;
				}
			}
		}
		return false;
    }
	
	public static boolean dfs(int[] nums, int index, int[] visited) {
		visited[index] = 1;
		
		int next = ((nums[index] + index) % nums.length + nums.length) % nums.length;
		
		
		if (visited[next] == 0) {
			return dfs(nums, next, visited);
		}
		else if (visited[next] == 1) {
			start = next;
			end = index;
			return false;
		}
		
		visited[index] = 2;
		return true;
		
	}

	public static void main(String[] args) {
//		int[] nums = {2,-1,1,2,2};
//		int[] nums = {-2,1,-1,-2,-2};
//		int[] nums = {-1,2};
//		int[] nums = {3,1,2};
		int[] nums = {-2,-17,-1,-2,-2};
		
		System.out.println(circularArrayLoop(nums));
	}

}
