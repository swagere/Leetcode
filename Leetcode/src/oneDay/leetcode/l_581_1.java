package oneDay.leetcode;

//r
//���ҳ�û�а���������ߵݼ���������
//ȷ���м�ķ�Χ�����������������ߵ�Ԫ�ر��������Ԫ�ش� ���ұߵ�Ԫ�ر��ұ�����Ԫ��С
//ȷ�������������м�����飬�����߽�λ��
public class l_581_1 {

	public static int findUnsortedSubarray(int[] nums) {
		int low = 0;
		
		int high = nums.length - 1;
		
		boolean flag = false;
		
		//�ҵ�ת�۵�
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] > nums[i + 1]) {
				low = i;
				flag = true;
				break;
			}
		}
		
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] < nums[i - 1]) {
				high = i;
				flag = true;
				break;
			}
		}
		
		
		int l = low;
		int r = high;
		int min = nums[low];
		int max = nums[high];
		for (int i = l; i <= r; i++) {
			if (nums[i] < min) {
				//�ƶ���ָ��
				while (low >= 0 && nums[i] < nums[low]) {
					low--;
				}
				min = low >= 0 ? nums[low]: min; 
			}
			
			if (nums[i] > max) {
				while (high < nums.length && nums[i] > nums[high]) {
					high++;
				}
				max = high < nums.length ? nums[high] : max;
			}
		}
		
		if (flag == false) {
			return 0;
		}
		
		return high - low - 1;
    }
	
	public static void main(String[] args) {
		int[] nums = {2,1};
		
		System.out.println(findUnsortedSubarray(nums));

	}

}
