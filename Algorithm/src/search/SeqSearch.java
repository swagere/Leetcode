package search;

public class SeqSearch {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,2};

		System.out.println(seqSearch(nums, 2));
	}

	//���Բ���
	//�ҵ�һ���ͷ��� ����ֵΪ�±�
	private static int seqSearch(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (i == target) {
				return i;
			}
		}
		return -1;
	}

}
