package oneDay.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class o_41 {

	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(-1);
		m.addNum(-2);
		m.addNum(-3);
		m.addNum(-4);
		System.out.println(m.findMedian());
	}

}

//list
class MedianFinder1 {
	List<Integer> list;
	int len;

    /** initialize your data structure here. */
    public MedianFinder1() {
    	this.list = new ArrayList<>();
    	len = 0;
    }
    
    public void addNum(int num) {
    	len += 1;
    	for (int i = 0; i < list.size(); i++) {
    		if (num <= list.get(i)) {
    			list.add(i, num);
    			return;
    		}
    	}
    	list.add(num);
    }
    
    public double findMedian() {
    	int mid = len / 2;
    	if (len % 2 == 0) {
    		return (double)(list.get(mid) + list.get(mid - 1)) / (double)2;
    	}
    	return list.get(mid);
    }
}

//两个优先队列/堆
class MedianFinder {
	PriorityQueue<Integer> small;
	PriorityQueue<Integer> large;

    /** initialize your data structure here. */
    public MedianFinder() {
    	small = new PriorityQueue<Integer>((v1, v2) -> v2 - v1);
    	large = new PriorityQueue<Integer>();
    }
    
    //large的数量多
    public void addNum(int num) {
    	if (small.size() < large.size()) {
    		if (small.size() > 0 && num <= small.peek()) {
    			small.offer(num);
    		}
    		else if (num <= large.peek()) {
				small.offer(num);
			}
			else {
				small.offer(large.poll());
				large.offer(num);
			}
    	}
    	else {
    		if (small.size() > 0 && num <= small.peek()) {
    			large.offer(small.poll());
    			small.offer(num);
    		}
			else {
				large.offer(num);
			}
    	}
    }
    
    public double findMedian() {
    	if (large.size() == small.size()) {
    		return ((double)large.peek() + (double)small.peek()) / (double)2;
    	}
    	return (double)large.peek();
    }
}