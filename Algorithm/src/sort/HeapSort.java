package sort;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int[] nums = {1,5,-1,36,0,132,365,465645,2,-213};
		
		heapSort(nums);
		System.out.println(Arrays.toString(nums));

	}

	//堆排序
	//以从小到大为例 使用大顶堆
	private static void heapSort(int[] nums) {
		//先进行一轮排序 将整个数组化成有序的
		for (int i = nums.length / 2 - 1; i >= 0; i--) {
			//从第一个非叶子节点开始‘
			adjustHeap(nums, i, nums.length);
		}
		
		for (int i = nums.length - 1; i > 0; i--) {
			//将最后一个和排好序的第一个最大值交换
			int temp = nums[0];
			nums[0] = nums[i];
			nums[i] = temp;
			
			//新范围的数组循环 此时只用循环最顶端 即只需要把最顶端的放在合适位置即可
			adjustHeap(nums, 0, i);
		}
		
	}
	
	//每次调整堆
	//i为需要排序的位置
	public static void adjustHeap(int[] nums, int index, int length) {
		//相当于插入排序中一个个移位
		int temp = nums[index]; //要排的位置
		
		//先找左子节点
		for (int i = 2 * index + 1; i < length; i = 2 * index + 1) { // 下一轮继续找下一个结点的左子节点
			//与右子节点比较 保留较大的数
			if (i + 1 < length && nums[i] < nums[i + 1]) { //检测i+1的大小
				i += 1;
			}
			
			//比较根节点
			if (nums[i] > temp) {
				nums[index] = nums[i];
				index = i;
			}
			else {
				break;
			}
		}
		
		//把temp放在已排好序的正确位置
		nums[index] = temp;
	}

}
