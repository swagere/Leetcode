package oneDay.offer;

//r
//���ֲ��� + ��������
//���ֲ���˫�ߣ������Ż���
//�������ұ߽�Ϊ�����ӵ�һ��������targetֵ��ʼ����������ֱ��midֵ������target�ҵ��ұ߽�
public class o_53_3 {
	public static int search(int[] nums, int target) {
		//�ұ߽�
		int left = 0;
		int right = nums.length - 1;
		int mid = (left + right) / 2;
		//�ҵ��ұ߽�
        while (left <= right) {
        	if (target < nums[mid]) {
        		right = mid - 1;
        		mid = (left + right) / 2;
        	}
        	else if (target >= nums[mid]) {
        		left = mid + 1;
        		mid = (left + right) / 2;
        	}
        }
        System.out.println(left);
        System.out.println(right);
        System.out.println(mid);
        System.out.println();
        int r = left; 
        
        //��ǰ����
        if (nums.length == 0 || nums[mid] != target) {
        	return 0;
        }
        
        //��߽�
        left = 0;
        right = nums.length - 1;
		mid = (left + right) / 2;
		//�ҵ���߽�
        while (left <= right) {
        	
        	if (target <= nums[mid]) {
        		right = mid - 1;
        		mid = (left + right) / 2;
        	}
        	else {
        		left = mid + 1;
        		mid = (left + right) / 2;
        	}
        }
        int l = right;
        System.out.println(left);
        System.out.println(right);
        System.out.println(mid);
        System.out.println();

        return r - l - 1;
    }

	public static void main(String[] args) {
		int[] nums = {5,7,8,8,8,9};
		System.out.println(search(nums, 8));
	}

	
}
