package oneDay.offer;

import java.util.ArrayList;
import java.util.List;

public class o_45 {

	public static void main(String[] args) {
		int[] nums = {121,12};
		System.out.println(new Solution451().minNumber(nums));
	}
}

class Solution451 {
    public String minNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        StringBuffer buffer = new StringBuffer();
        for (int i : nums) {
        	buffer.append(i);
        }
        return buffer.toString();
    }
    
    public void quickSort(int[] nums, int l, int r) {
    	if (l >= r) {
    		return;
    		
    	}
    	swap(nums, l + (int)((r - l) * Math.random()), r);
    	int[] p = partition(nums, l, r);
    	quickSort(nums, p[1] + 1, r);
    	quickSort(nums, l, p[0] - 1);
    }

	private int[] partition(int[] nums, int l, int r) {
		int less = l - 1;
    	int more = r;
		while (l < more) {
    		if (compare(nums[l], nums[r]) == -1) {
    			swap(nums, l, less + 1);
    			less += 1;
    			l += 1;
    		}
    		else if (compare(nums[l], nums[r]) == 1) {
    			swap(nums, l, more - 1);
    			more -= 1;
    		}
    		else if (compare(nums[l], nums[r]) == 0){
    			l += 1;
    		}
    	}
		swap(nums, more, r);
		return new int[] {less + 1, more};
	}
	
	/**
	 * 1 i大
	 * -1 j大
	 * 0 相等
	 */
	private int compare(int i, int j) {
		List<Integer> ii = getNumber(i, j);
		List<Integer> jj = getNumber(j, i);
		int k = 0;
		while (k < jj.size() && k < ii.size()) {
			if (ii.get(k) > jj.get(k)) {
				return -1;
			}
			else if (ii.get(k) < jj.get(k)) {
				return 1;
			}
			else {
				k += 1;
			}
		}
		return 0;
	}

	private List<Integer> getNumber(int i, int j) {
		List<Integer> res = new ArrayList<>();
		while (i > 9) {
			res.add(0, i % 10);
			i = (i - i % 10) / 10;
		}
		res.add(0, i);
		
		while (j > 9) {
			res.add(0, j % 10);
			j = (j - j % 10) / 10;
		}
		res.add(0, j);
		return res;
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}