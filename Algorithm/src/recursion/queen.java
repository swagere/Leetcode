package recursion;

//�˻ʺ�����
//�ݹ���
public class queen {

	//��¼�߹��Ĳ���
	//����ά����ת��Ϊһά����
	//ȫ�ֱ���
	static int[] step = new int[8];
	
	//��ʾ�ʺ�����
	static int max = 8;
	
	//��¼�ɹ�����
	static int count = 0;
	
	public static void main(String[] args) {
		recursion(0);
		System.out.println(count);
	}

	//���ؿ��������������
	private static void recursion(int n) {
		if (n == max) {
			count++;
			return;
		}
		for (int i = 0; i < max; i++) {
			if (check(n, i)) {
				step[n] = i;
				recursion(n + 1);
			}
		}
	}

	//�ж��Ƿ��ͻ���Ƿ���ͬһ�С�ͬһ�С�ͬһб��
	private static boolean check(int n, int i) {
		for (int j = 0; j < n; j++) {
			if (step[j] == i || Math.abs(n - j) == Math.abs(i - step[j])) { //abs
				return false;
			}
		}
		return true;
	}
}
