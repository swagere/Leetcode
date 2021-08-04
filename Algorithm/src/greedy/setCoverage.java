package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//贪心算法解决集合覆盖问题
public class setCoverage {

	public static void main(String[] args) {
		Map<String, List<String>> broadcasts = new HashMap<>();
		
		List<String> list1 = new ArrayList<String>();
		list1.add("北京");
		list1.add("上海");
		list1.add("天津");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("广州");
		list2.add("北京");
		list2.add("深圳");
		
		List<String> list3 = new ArrayList<String>();
		list3.add("成都");
		list3.add("上海");
		list3.add("杭州");
		
		List<String> list4 = new ArrayList<String>();
		list4.add("上海");
		list4.add("天津");
		
		List<String> list5 = new ArrayList<String>();
		list5.add("杭州");
		list5.add("大连");
		
		broadcasts.put("K1", list1);
		broadcasts.put("K2", list2);
		broadcasts.put("K3", list3);
		broadcasts.put("K4", list4);
		broadcasts.put("K5", list5);
		
		List<String> selected = new ArrayList<String>();
		Set<String> allAreas = new HashSet<String>();
		allAreas.addAll(list1);
		allAreas.addAll(list2);
		allAreas.addAll(list3);
		allAreas.addAll(list4);
		allAreas.addAll(list5);
		

		while (allAreas.size() != 0) {
			int max = 0;
			String index = null;
			for (String key : broadcasts.keySet()) {
				List<String> areas = broadcasts.get(key);
				int count = 0;
				for (String area : areas) {
					if (allAreas.contains(area)) {
						count += 1;
					}
				}
				
				if (count > max) {
					max = count;
					index = key;
				}
			}

			if (index != null) {
				//找到了最大值
				//1. allArea中移除
				List<String> areas = broadcasts.get(index);
				for (String area : areas) {
					allAreas.remove(area);
				}
				
				//2. 加入selected
				selected.add(index);
			}
		}
		
		System.out.println(selected);
	}

}
