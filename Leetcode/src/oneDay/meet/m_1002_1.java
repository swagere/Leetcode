package oneDay.meet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//r
//������
//list+list/map
public class m_1002_1 {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> pattern = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
        	//����
        	char[] c = strs[i].toCharArray();
        	Arrays.sort(c);
        	String p = String.copyValueOf(c);
        	
        	//�Ƚϲ�����
        	int index = pattern.indexOf(p);
        	if (index == -1) {
        		pattern.add(p);
        		res.add(new ArrayList<>());
        	}
        	
        	res.get(pattern.indexOf(p)).add(strs[i]);
        }
        
        
        return res;
    }

	public static void main(String[] args) {
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));

	}

}
