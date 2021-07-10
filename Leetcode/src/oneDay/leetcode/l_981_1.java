package oneDay.leetcode;

import java.util.ArrayList;
import java.util.List;

//三个list
//逆向存储
//r
public class l_981_1 {
    
	public static void main(String[] args) {
		TimeMap timeMap = new TimeMap();
		timeMap.set("love","high",10);
		timeMap.set("love","low",20);
		System.out.println(timeMap.get("love",5));
		System.out.println(timeMap.get("love",10));
		System.out.println(timeMap.get("love",15));
		System.out.println(timeMap.get("love",20));
		System.out.println(timeMap.get("love",25));
	}

}

class TimeMap {
	List<String> key;
	List<String> value;
	List<Integer> timestamp;

    public TimeMap() {
    	key = new ArrayList<>();
    	value = new ArrayList<>();
    	timestamp = new ArrayList<>();
    }
    
    public void set(String key, String value, int timestamp) {
    	this.key.add(0, key);
    	this.value.add(0, value);
    	this.timestamp.add(0, timestamp);
    }
    
    public String get(String key, int timestamp) {
    	int index = -1;
    	for (int i = 0; i < this.key.size(); i++) {
    		String k = this.key.get(i);
    		int t = this.timestamp.get(i);
    		if (k.equals(key)) {
    			if (t <= timestamp) { //所有 TimeMap.set 操作中的时间戳 timestamps 严格递增的
    				index = i;
    				break;
    			}
    		}
    	}
    	return index == -1 ? "" : this.value.get(index);
    }
}