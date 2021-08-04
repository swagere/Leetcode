package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//̰���㷨������ϸ�������
public class setCoverage {

	public static void main(String[] args) {
		Map<String, List<String>> broadcasts = new HashMap<>();
		
		List<String> list1 = new ArrayList<String>();
		list1.add("����");
		list1.add("�Ϻ�");
		list1.add("���");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("����");
		list2.add("����");
		list2.add("����");
		
		List<String> list3 = new ArrayList<String>();
		list3.add("�ɶ�");
		list3.add("�Ϻ�");
		list3.add("����");
		
		List<String> list4 = new ArrayList<String>();
		list4.add("�Ϻ�");
		list4.add("���");
		
		List<String> list5 = new ArrayList<String>();
		list5.add("����");
		list5.add("����");
		
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
				//�ҵ������ֵ
				//1. allArea���Ƴ�
				List<String> areas = broadcasts.get(index);
				for (String area : areas) {
					allAreas.remove(area);
				}
				
				//2. ����selected
				selected.add(index);
			}
		}
		
		System.out.println(selected);
	}

}
