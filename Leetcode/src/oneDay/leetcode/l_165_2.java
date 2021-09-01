package oneDay.leetcode;

//r
//双指针
public class l_165_2 {
	public static int compareVersion(String version1, String version2) {
        int i = 0;
        int j = 0;
        String s1 = "";
        String s2 = "";
        while (i < version1.length() && j < version2.length()) {
        	s1 = "";
        	while (i < version1.length() && version1.charAt(i) != '.') {
        		s1 += version1.charAt(i);
        		i++;
        	}
        	if (i < version1.length()) {
        		i++;
        	}
        	
        	s2 = "";
        	while (j < version2.length() && version2.charAt(j) != '.') {
        		s2 += version2.charAt(j);
        		j++;
        	}
        	if (j < version2.length()) {
        		j++;
        	}
        	
        	if (Integer.valueOf(s1) > Integer.valueOf(s2)) {
        		return 1;
        	}
        	else if (Integer.valueOf(s1) < Integer.valueOf(s2)) {
        		return -1;
        	}
        }
        
        //如果是v2没有位数
        while (i < version1.length()) {
        	s1 = "";
        	while (i < version1.length() && version1.charAt(i) != '.') {
        		s1 += version1.charAt(i);
        		i++;
        	}
        	if (i < version1.length()) {
        		i++;
        	}
        	
        	if (0 < Integer.valueOf(s1)) {
        		return 1;
        	}
        }
        
        //如果是v1没有位数
        while (j < version2.length()) {
        	s2 = "";
        	while (j < version2.length() && version2.charAt(j) != '.') {
        		s2 += version2.charAt(j);
        		j++;
        	}
        	if (j < version2.length()) {
        		j++;
        	}
        	
        	if (0 < Integer.valueOf(s2)) {
        		return -1;
        	}
        }
        
        return 0;
    }

	public static void main(String[] args) {
		String version1 = "1";
		String version2 = "1.0.1";
		
		System.out.println(compareVersion(version1, version2));

	}

}
