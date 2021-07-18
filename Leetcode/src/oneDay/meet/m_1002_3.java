package oneDay.meet;

import java.util.ArrayList;
import java.util.List;

//r
//使用 26个质数 代表26个字符 质数相乘结果一定不相等
//质数分解唯一性
public class m_1002_3 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		int[] pr = {2,3,5,7,11,13,17,19,23,29,31,37,41, 43, 47, 53, 59, 61, 67, 71,73,79,83,89,97,101}; //26个质数
        List<Integer> pattern = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        
        for(int i = 0; i < strs.length; i++) {
        	int sum = 1;
        	//字母和出现次数按顺序拼接成字符串
        	for (char j : strs[i].toCharArray()) {
        		sum *= pr[j - 'a'];
        	}
        	
        	//比较并放入
        	int index = pattern.indexOf(sum);
        	if (index == -1) {
        		pattern.add(sum);
        		res.add(new ArrayList<>());
        	}
        	
        	res.get(pattern.indexOf(sum)).add(strs[i]);
        }
        
        
        return res;
    }

	public static void main(String[] args) {
		String[] strs = {"ron","huh","gay","tow","moe","tie","who","ion","rep","bob","gte","lee","jay","may","wyo","bay","woe","lip","tit","apt","doe","hot","dis","fop","low","bop","apt","dun","ben","paw","ere","bad","ill","fla","mop","tut","sol","peg","pop","les"};
		System.out.println(groupAnagrams(strs));

	}

}
