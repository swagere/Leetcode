//package oneDay.leetcode;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
////Ƕ��map:��¼ĳ�� key ��Ӧ����Щ Node
////����洢 timestamp�����ǰ�� 
////r
//public class l_981_2 {
//    
//	public static void main(String[] args) {
//		TimeMap timeMap = new TimeMap();
//		timeMap.set("love","high",10);
//		timeMap.set("love","low",20);
//		System.out.println(timeMap.get("love",5));
//		System.out.println(timeMap.get("love",10));
//		System.out.println(timeMap.get("love",15));
//		System.out.println(timeMap.get("love",20));
//		System.out.println(timeMap.get("love",25));
//		System.out.println(timeMap.get("hi",25));
//	}
//
//}
//
//class TimeMap {
//	private Map<String, List<Node>> map;
//
//    public TimeMap() {
//    	map = new HashMap<>();
//    }
//    
//    public void set(String key, String value, int timestamp) {
//    	List<Node> list = new ArrayList<>();
//    	if (map.containsKey(key)) {
//    		list = map.get(key);
//    		
//    	}
//    	
//    	list.add(0, new Node(value, timestamp));
//    	map.put(key, list);
//    }
//    
//    public String get(String key, int timestamp) {
//    	List<Node> list = map.get(key);
//    	if (list == null || list.isEmpty()) {
//    		return "";
//    	}
//    	int index = 0;
//    	boolean flag = false;
//    	for (int i = 0; i < list.size(); i++) {
//    		int t = list.get(i).timestamp;
//			if (t <= timestamp) { //���� TimeMap.set �����е�ʱ��� timestamps �ϸ������
//				flag = true;
//				index = i;
//				break;
//			}
//    	}
//    	return flag == false ? "" : list.get(index).value;
//    }
//}
//
//class Node {
//	String value;
//	int timestamp;
//	
//	public Node(String value, int timestamp) {
//		this.value = value;
//		this.timestamp = timestamp;
//	}
//}