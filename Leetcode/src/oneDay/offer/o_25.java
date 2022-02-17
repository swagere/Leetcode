package oneDay.offer;

public class o_25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//Ë«Ö¸Õë
class Solution251 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode m = l1;
    	ListNode n = l2;
    	ListNode newHead = new ListNode(-1);
    	ListNode temp = newHead;
    	while (m != null && n != null) {
    		if (m.val > n.val) {
    			temp.next = n;
    			n = n.next;
    			temp = temp.next;
    		}
    		else {
    			temp.next = m;
    			m = m.next;
    			temp = temp.next;
    		}
    	}
    	
    	if (m != null) {
    		temp.next = m;
			m = m.next;
			temp = temp.next;
    	}
    	
    	if (n != null) {
    		temp.next = n;
			n = n.next;
			temp = temp.next;
    	}
    	
    	return newHead.next;
    }
}

