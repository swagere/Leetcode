package real.m9_12_mhy;
import java.util.*;

//w
//Ī������
public class Solution2_1 {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * ��ȡ�ַ���
     * @param original string�ַ��� 
     * @param count int���� 
     * @return string�ַ���
     */
    public static String cutString (String original, int count){
        byte[] bytes = original.getBytes();
        System.out.println(Arrays.toString(bytes));
        
        if (bytes[count - 1] < 0 && bytes[count] < 0) {
        	byte[] res = Arrays.copyOf(bytes, count - 1);
        	return new String(res);
        }
        else {
        	byte[] res = Arrays.copyOf(bytes, count);
        	return new String(res);
        }
    }
    
    public static void main(String[] args) {
		String original = "��ABC��DEF";
		int count = 8;
		System.out.println(cutString(original, count));
	}
}