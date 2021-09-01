package oneDay.leetcode;

//r
//����
public class l_165_1 {
	public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while (i < v1.length && j < v2.length) {
        	if (Integer.valueOf(v1[i]) > Integer.valueOf(v2[j])) {
        		return 1;
        	}
        	else if (Integer.valueOf(v1[i]) < Integer.valueOf(v2[j])) {
        		return -1;
        	}
        	i++;
        	j++;
        }
        
        //�����v2û��λ��
        while (i < v1.length) {
        	if (0 < Integer.valueOf(v1[i])) {
        		return 1;
        	}
        	i++;
        }
        
        //�����v1û��λ��
        while (j < v2.length) {
        	if (0 < Integer.valueOf(v2[j])) {
        		return -1;
        	}
        	j++;
        }
        
        return 0;
    }

	public static void main(String[] args) {
		String version1 = "1.01";
		String version2 = "1.01";
		
		System.out.println(compareVersion(version1, version2));

	}

}
