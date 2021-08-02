package oneDay.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//r
//�����ʼ�����Ƿ�Ϊ1 ��ͬʱ���� �����������
//����ûզ��
public class l_1337_2 {

	public static int[] kWeakestRows(int[][] mat, int k) {
		List<Integer> res = new ArrayList<>();
		
		int j = 0;
		for (; j < mat[0].length; j++) {
			for (int i = 0; i < mat.length; i++) {
				if (mat[i][j] == 0 && !res.contains(i)) { //�ҵ�ÿ�е�һ���Ǿ���
					res.add(i);
					break;
				}
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			if (mat[i][j - 1] == 1) {
				res.add(i);
			}
		}
		
		return res.subList(0, k).stream().mapToInt(Integer::valueOf).toArray();
    }
	
	public static void main(String[] args) {
		int[][] mat = {{1,1,1,1,1},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,0},{1,1,1,1,1}};
		int k = 3;
		System.out.println(Arrays.toString(kWeakestRows(mat, k)));

	}

}
