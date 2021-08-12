package offer;

import java.util.Stack;

//增加一个辅助栈，用于依次保存最小值
public class o_30 {

}
class MinStack {
    Stack<Integer> stack;
    Stack<Integer> helper;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (helper.size() == 0 || helper.peek() >= x) {
            helper.push(x);
        }
    }
    
    public void pop() {
        int value = stack.pop();
        if (helper.size() > 0 && value == helper.peek()) {
            helper.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        if (helper.size() == 0) {
            helper.push(stack.peek());
        }
        return helper.peek();
    }
}