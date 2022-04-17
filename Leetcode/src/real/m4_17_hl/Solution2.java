package real.m4_17_hl;
import java.util.*;


class ListNode {
	int val;
	ListNode next = null;
	public ListNode(int val) {
	this.val = val;
	}
}
 


public class Solution2 {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		System.out.println(ReverseList(head).next.val);
	}
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param pHead ListNode类 
     * @return ListNode类
     */
    public static ListNode ReverseList (ListNode pHead) {
    	if (pHead == null) {
    		return null;
    	}
    	ListNode newHead = new ListNode(0);
    	ListNode cur = pHead;
    	while (cur != null) {
    		ListNode temp = cur.next;
    		cur.next = newHead.next;
    		newHead.next = cur;
    		cur = temp;
    	}
    	
    	return newHead.next;
    }
}