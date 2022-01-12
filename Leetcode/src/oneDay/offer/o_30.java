package oneDay.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//两个大小相等的栈
public class o_30 {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		System.out.println(minStack.min());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.min());
	}

}
class MinStack {
	private Stack<Integer> stack;
	private List<Integer> list;
	

    /** initialize your data structure here. */
    public MinStack() {
    	this.stack = new Stack<>();
    	this.list = new ArrayList<>();
    }
    
    public void push(int x) {
    	stack.push(x);
    	if (list.size() == 0) {
    		list.add(x);
    	}
    	else {
    		for (int i = 0; i < this.list.size(); i++) {
        		if (x <= list.get(i)) {
        			list.add(i, x);
        			break;
        		}
        		i += 1;
        		if (i == this.list.size()) {
        			list.add(i,x);
        		}
        	}
    	}
    }
    
    public void pop() {
    	Integer res = stack.pop();
    	list.remove(res);
    }
    
    public int top() {
    	return stack.peek();
    }
    
    public int min() {
    	return  list.get(0);
    }
}
