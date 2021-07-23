package oneDay.leetcode;

//import java.util.Arrays;

//r
//����
//���ÿ�ε�ֵ �����Ҫ�������ڱ��� �����нڵ㶼�������˵��
//�Ż���ֻ��Ҫ���left��right֮���ֵ
public class l_1893_1 {
	public static boolean isCovered(int[][] ranges, int left, int right) {
		int[] covered = new int[right + 1];
		for (int[] item : ranges) {
			for (int i = item[0]; i <= item[1]; i++) {
				//��left��ʼ
				if (i < left) {
					if (left > item[1]) {
						i = left - 1;
						continue;
					}
				}
				
				//��right����
				if (i <= right) {
					covered[i]++;
				}
				else {
					break;
				}
			}
		}
		
//		System.out.println(Arrays.toString(covered));
		
		
		for (int i = left; i <= right; i++) {
			if (covered[i] <= 0) {
				return false;
			}
		}
		
		return true;
    }

	public static void main(String[] args) {
//		int[][] ranges = {{1,2},{3,4},{5,6}};
		int[][] ranges = {{1,10},{10,20}};
		int left = 21;
		int right = 21;
		System.out.println(isCovered(ranges, left, right));
	}

}
