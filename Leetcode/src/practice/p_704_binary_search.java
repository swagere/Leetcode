package practice;

import java.util.Scanner;

//¶ş·Ö²éÕÒ

//target index left right mid
public class p_704_binary_search {
    public static int search(int[] nums, int target) {
    	int left = 0;
    	int right = nums.length;
    	int mid = (right - left) / 2 + left;
    	while (nums[mid] != target) {
    		if (nums[mid] > target) {
    			right = mid;
    		}
    		if (nums[mid] < target) {
    			left = mid;
    		}
    		mid = (right - left) / 2 + left;
    		
    		if (mid == left && nums[mid] != target) {
    			return -1;
    		}
    	}
    	return mid;
    }

	public static void main(String[] args) {
		int[] nums = {2,5};
		int target = 5;
		System.out.println(search(nums, target));

	}

}
