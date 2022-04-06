package oneDay.offer¢ò;

public class o_22 {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode p = new ListNode(2);
		head.next = p;
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = p;
		System.out.println(new Solution221().detectCycle(head).val);
	}

}

//¿ìÂýÖ¸Õë
class Solution221 {
    public ListNode detectCycle(ListNode head) {
    	if (head == null || head.next == null) {
    		return null;
    	}
        ListNode slow = head;
        ListNode fast = head;
        ListNode p = head;
        
        while (fast != null && fast.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        	
        	while (slow == fast) {
        		while (p != slow) {
        			p = p.next;
            		slow = slow.next;
        		}
        		return p;
        	}
        }
        return null;
    }
}