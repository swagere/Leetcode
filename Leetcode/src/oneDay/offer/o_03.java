package oneDay.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class o_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//ֱ����list ��ʱ
class Solution031 {
    public int findRepeatNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int index = -1;
        for (int i : nums) {
        	if (!list.contains(Integer.valueOf(i))) {
        		list.add(i);
        	}
        	else {
        		index = i;
        	}
        }
        return index;
    }
}

//�����˳�����
class Solution032 {
	public int findRepeatNumber(int[] nums) {
    	int index = -1;
    	Arrays.sort(nums);
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] == nums[i - 1]) {
    			index = nums[i];
    			break;
    		}
    	}
    	return index;
    }
}

//�������ֲ���
class Solution033 {
    public int findRepeatNumber(int[] nums) {
    	int index = -1;
    	Arrays.sort(nums);
    	//���ֲ���
    	
    	
    	return index;
    }
}
