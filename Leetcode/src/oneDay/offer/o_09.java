package oneDay.offer;

import java.util.Stack;

public class o_09 {

	public static void main(String[] args) {
		CQueue cQueue = new CQueue();
		cQueue.appendTail(1);
		cQueue.appendTail(2);
		cQueue.appendTail(3);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());

	}

}

class CQueue {
    private Stack<Integer> in;
    private Stack<Integer> out;
    

    public CQueue() {
    	in = new Stack<>();
    	out = new Stack<>();
    }
    
    public void appendTail(int value) {
    	in.push(value);
    }
    
    public int deleteHead() {
    	int res = -1;
    	if (out.size() > 0) {
    		res = out.pop();
    	}
    	else {
    		if (in.size() > 0) {
    			while (in.size() > 0) {
    				out.push(in.pop());
    			}
    			res = out.pop();
    		}
    	}
    	return res;
    }
}