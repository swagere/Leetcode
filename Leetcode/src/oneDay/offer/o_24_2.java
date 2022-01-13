package oneDay.offer;

//Ë«Ö¸Õë
public class o_24_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution242 {
    public ListNode reverseList(ListNode head) {
    	ListNode pre = null;
    	ListNode cur = null;
    	if (head != null) {
    		if (head.next != null) {
    			pre = head;
    			pre.next = null;
    			cur = head.next;
    			while (cur != null) {
    				ListNode temp = cur.next;
    				cur.next = pre;
    				pre = cur;
    				cur = temp;
    			}
    		}
    	}
    	return pre;
    }
}