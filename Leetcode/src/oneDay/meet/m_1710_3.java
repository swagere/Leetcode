package oneDay.meet;

//r


public class m_1710_3 {
	public static int majorityElement(int[] nums) {
		//Ħ��ͶƱ �ȼ�������ܳ���һ���Ԫ��
		//cur���ڼ�����ǰ���ظ����� count���ڼ������� �ɲ��ı�ԭnums����
		
		int count = 0;
		int cur = -1;
		for (int i : nums) {
			if (count == 0) {
				cur = i;
				count++;
			}
			else {
				if (i == cur) {
					count++;
				}
				else {
					count--;
				}
			}
		}
		
		//ȷ���Ƿ񳬹�һ��
		count = 0;
		for (int i : nums) {
			if (i == cur) {
				count++;
			}
		}
		
		return count > nums.length / 2 ? cur : -1;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,5,9,5,9,5,5,5};
		System.out.println(majorityElement(nums));
	}

}
