package real.m9_12_mhy;

//r
public class Solution2_2 {
    /**
     * �����е����������������������Ѿ�ָ���������޸ģ�ֱ�ӷ��ط����涨��ֵ����
     *
     * ��ȡ�ַ���
     * @param original string�ַ��� 
     * @param count int���� 
     * @return string�ַ���
     */
    public static String cutString (String original, int count){
    	int n = count;
    	String str = new String(original);
    	StringBuffer res = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
        	byte[] temp = String.valueOf(str.charAt(i)).getBytes();
        	if (temp.length == 2) {
        		n -= 2;
        	}
        	if (n >= i - 1) {
        		res.append(str.charAt(i));
        	}
        }
        return res.substring(0);
    }
    
    public static void main(String[] args) {
		String original = "��ABC��DEF"; 
		int count = 6;
		System.out.println(cutString(original, count));
	}
}