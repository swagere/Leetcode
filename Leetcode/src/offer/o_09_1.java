package offer;

import java.util.Stack;

public class o_09_1 {

}

class CQueue {
	Stack<Integer> queue1 = new Stack<Integer>();
    Stack<Integer> queue2 = new Stack<Integer>();

    public CQueue() {
    	
    }
    
    public void appendTail(int value) {
        queue1.push(value);
    }
    
    public int deleteHead() {
    	int cur = -1;
    	while (queue1.size() > 1) {
    		queue2.push(queue1.pop());
    	}
    	
    	if (queue1.size() == 1) {
    		cur = queue1.pop();
    	}

    	while (queue2.size() > 0) {
    		queue1.push(queue2.pop());
    	}
    	
    	return cur;
    }
}