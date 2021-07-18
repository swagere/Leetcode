package oneDay.meet;

import java.util.ArrayList;
import java.util.List;

//r
//字母和出现次数按顺序拼接成字符串 解决
//用cnt[26] 用数字代替字母
//list+list/map
public class m_1002_2 {
	public static List<List<String>> groupAnagrams(String[] strs) {
        List<String> pattern = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
        	int[] cnt = new int[26];
        	//字母和出现次数按顺序拼接成字符串
        	for (char j : strs[i].toCharArray()) {
        		cnt[j - 'a']++;
        	}
        	
        	String num = "";
        	for (int j = 0; j < 26; j++) {
        		if (cnt[j] != 0) {
        			num += j + " " + cnt[j];
        		}
        	}
        	
        	//比较并放入
        	int index = pattern.indexOf(num);
        	if (index == -1) {
        		pattern.add(num);
        		res.add(new ArrayList<>());
        	}
        	
        	res.get(pattern.indexOf(num)).add(strs[i]);
        }
        
        
        return res;
    }

	public static void main(String[] args) {
		String[] strs = {"ron","huh","gay","tow","moe","tie","who","ion","rep","bob","gte","lee","jay","may","wyo","bay","woe","lip","tit","apt","doe","hot","dis","fop","low","bop","apt","dun","ben","paw","ere","bad","ill","fla","mop","tut","sol","peg","pop","les"};
		System.out.println(groupAnagrams(strs));

	}

}
