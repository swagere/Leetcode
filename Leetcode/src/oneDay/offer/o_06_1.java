package oneDay.offer;

import java.util.Stack;

//¸¨ÖúÕ»
public class o_06_1 {

	public static void main(String[] args) {
		

	}

}

class Solution061 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
        	stack.push(temp.val);
        	temp = temp.next;
        }
        
        int[] res = new int[stack.size()];
        int index = 0;
        while (stack.size() > 0) {
        	res[index] = stack.pop();
        	index += 1;
        }
        return res;
    }
}
