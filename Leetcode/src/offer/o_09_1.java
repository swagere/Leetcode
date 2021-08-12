package offer;

import java.util.Stack;

//r
//每次取数据都拿出栈底元素 另一个栈用来暂时存放
public class o_09_1 {

}

class CQueue {
	Stack<Integer> queue1;
    Stack<Integer> queue2;

    public CQueue() {
    	queue1 = new Stack<Integer>();
        queue2 = new Stack<Integer>();
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