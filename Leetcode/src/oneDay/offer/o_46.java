package oneDay.offer;

import java.util.ArrayList;
import java.util.List;

public class o_46 {

	public static void main(String[] args) {
		int num = 506;
		System.out.println(Solution462.translateNum(num));

	}

}
//��̬�滮
class Solution461 {
    public static int translateNum(int num) {
    	//�ֳɵ���ֵ
    	List<Integer> nums = new ArrayList<>();
    	while (num > 9) {
    		nums.add(0, num % 10);
    		num /= 10;
    	}
    	nums.add(0, num);

    	//������
    	int a = 1;
    	int b = 1;
    	for (int i = 1; i < nums.size(); i++) {
    		if (nums.get(i - 1) * 10 + nums.get(i) < 26 && nums.get(i - 1) != 0) { //��ȥʮλΪ0�����
    			int temp = a + b;
    			a = b;
    			b = temp;
    		}
    		else {
    			a = b;
    		}
    	}

    	return b;
    }
}

//�Ż����ַ���+��̬�滮
class Solution462 {
  public static int translateNum(int num) {
  	String nums = String.valueOf(num);

  	//������
  	int a = 1;
  	int b = 1;
  	for (int i = 1; i < nums.length(); i++) {
  		if (Integer.valueOf(nums.substring(i - 1, i + 1)) < 26 && Integer.valueOf(nums.substring(i - 1, i + 1)) > 9) { //��ȥʮλΪ0�����
  			int temp = a + b;
  			a = b;
  			b = temp;
  		}
  		else {
  			a = b;
  		}
  	}

  	return b;
  }
}