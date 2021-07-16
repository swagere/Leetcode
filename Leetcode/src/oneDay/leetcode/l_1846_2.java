package oneDay.leetcode;

//r
//ʱ�临�Ӷ�:O(n)
//�������������� �������飬С��n����������nʱ�
//�������� + ̰��
public class l_1846_2 {
	public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
		int n = arr.length;
		int[] cnt = new int[n + 1];
		
		for (int i = 0; i < n; i++) {
			if (arr[i] <= n) {
				cnt[arr[i]]++;
			}
			else {
				cnt[n]++; //������n��Ԫ������n
			}
		}
		
		int miss = 0;
		for (int i = 1; i <= n; i++) {
			if (cnt[i] == 0) {
				miss++;
			}
			
			if (cnt[i] > 1) {
				miss = miss - Math.min((cnt[i] - 1), miss); //��ΪС�����ܱ��ֻ�д������ܼ���
			}
			
		}
		
		return n - miss;
    }

	public static void main(String[] args) {
		int[] arr = {2,2,1,2,1};
		System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
	}

}
