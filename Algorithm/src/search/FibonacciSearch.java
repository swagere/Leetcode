package search;

import java.util.Arrays;

//斐波拉契算法
public class FibonacciSearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6};
		
		int res = fibonacciSearch(nums, 3);
		if (res == -1) {
			System.out.println("没找到");
		}
		else {
			System.out.println(res);
		}

	}

	//斐波拉契算法
	//二分查找用循环实现
	private static int fibonacciSearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid = 0;
		int k = 0; //存储根据个数找到的最大的斐波拉契数
		
		//获得斐波拉契数列
		int[] f = fibonacci();
		
		while (right + 1 > f[k] - 1) {
			k++;
		}

		//填充原数组
		//长度为斐波拉契数 借助斐波拉契数列找到mid值
		int[] temp = Arrays.copyOf(nums, f[k]);
		for (int i = right + 1; i < f[k]; i++) {
			temp[i] = nums[right]; //将多填充的元素改为原数组中最大的元素 保持数组的有序性
		}
		
		//循环实现二分+斐波拉契
		while (left <= right) {
			mid = left + f[k - 1] - 1;
			if (temp[mid] > target) {
				right = mid - 1;
				k--; //左边为f[k - 1]
			}
			else if (temp[mid] < target) {
				left = mid + 1;
				k -= 2; //右边为f[k + 1]
			}
			else {
				//比较mid和length - 1的值，返回更小的那个
				return Math.min(mid, nums.length - 1);
			}
			
		}
		
		return -1;
	}

	//获得斐波拉契数列
	private static int[] fibonacci() {
		int maxSize = 20;
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		
		for (int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}

}
