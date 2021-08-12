package offer;

import java.util.Stack;

//r
//���Ƹ��ؾ���
//����ջ���н��г�
public class o_09_2 {

}

class CQueue1 {
    int in = 0;
    int out = 0;
    Stack<Integer> queue1;
    Stack<Integer> queue2;

    public CQueue1() {
    	queue1 = new Stack<Integer>();
        queue2 = new Stack<Integer>();
    }
    
    public void appendTail(int value) {
    	if (in % 2 == 0) {
    		queue1.push(value);
    		in++;
    	}
    	else {
    		queue2.push(value);
    		in++;
    	}
    }
    
    public int deleteHead() {
    	int cur = -1;
    	int size = 0;
    	if (out % 2 == 0) {
    		//��queue1��ɾ��
        	while (queue1.size() > 1) {
        		queue2.push(queue1.pop());
        		size++;
        	}
        	
        	if (queue1.size() == 1) {
        		cur = queue1.pop();
                out++;
        	}
        	
        	while (size > 0) {
        		queue1.push(queue2.pop());
                size--;
        	}
    	}
    	else {
    		//��queue2��ɾ��
        	while (queue2.size() > 1) {
        		queue1.push(queue2.pop());
        		size++;
        	}
        	
        	if (queue2.size() == 1) {
        		cur = queue2.pop();
                out++;
        	}
        	
        	while (size > 0) {
        		queue2.push(queue1.pop());
                size--;
        	}
    	}
    	
    	
    	
    	return cur;
    }
}