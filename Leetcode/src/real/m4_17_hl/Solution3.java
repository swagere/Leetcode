package real.m4_17_hl;
import java.util.*;

/*
 * public class ListNode {
 *   int val;
 *   ListNode next = null;
 *   public ListNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

public class Solution3 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param L1 ListNode类 
     * @param L2 ListNode类 
     * @return ListNode类
     */
    public ListNode mergeList (ListNode L1, ListNode L2) {
    	ListNode head = new ListNode(0);
    	ListNode temp = head;
        ListNode t1 = L1;
        ListNode t2 = L2;
        while (t1 != null && t2 != null) {
        	if (t1.val < t2.val) {
        		temp.next = t1;
        		temp = temp.next;
        		t1 = t1.next;
        	}
        	else {
        		temp.next = t2;
        		temp = temp.next;
        		t2 = t2.next;
        	}
        }
        
        if (t1 == null) {
        	while (t2 != null) {
        		temp.next = t2;
        		temp = temp.next;
        		t2 = t2.next;
        	}
        }
        if (t2 == null) {
        	while (t1 != null) {
        		temp.next = t1;
        		temp = temp.next;
        		t1 = t1.next;
        	}
        }
        return head.next;
    }
}