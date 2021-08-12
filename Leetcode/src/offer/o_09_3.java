package offer;

import java.util.Stack;

//r
//一个栈负责进 一个栈负责出
public class o_09_3 {

}

class CQueue2 {
	Stack<Integer> queue1;
    Stack<Integer> queue2;

    public CQueue2() {
    	queue1 = new Stack<Integer>(); //出
        queue2 = new Stack<Integer>(); //进
    }
    
    public void appendTail(int value) {
    	if (queue1.size() > 0) {
    		queue2.push(value);
    	}
    	else {
    		//将queue2移出
    		queue1.push(value);
    		
    		while (queue2.size() > 0) {
    			queue1.push(queue2.pop());
    		}
    		
    	}
    }
    
    public int deleteHead() {
    	int cur = -1;
    	if (queue1.size() > 0) {
    		cur = queue1.pop();
    	}
    	else if (queue2.size() > 0) {
    		while (queue2.size() > 0) {
    			queue1.push(queue2.pop());
    		}
            cur = queue1.pop();
    	}	
    	
    	return cur;
    }
}