package oneDay.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//ตÝน้
public class o_06_2 {

	public static void main(String[] args) {

	}

}

class Solution {
	List<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
       recur(head);
       int[] res = list.stream().mapToInt(Integer::valueOf).toArray();
       return res;
    }
    
    public void recur(ListNode node) {
    	if (node == null) {
    		return;
    	}
    	recur(node.next);
    	list.add(node.val);
    }
}
