package oneDay.offer;

public class o_18 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//Ë«Ö¸Õë
class Solution181 {
    public static ListNode deleteNode(ListNode head, int val) {
    	ListNode a = head;
    	if (a == null) {
    		return null;
    	}
    	else if (a.val == val) {
    		ListNode temp = head.next;
    		head.next = null;
    		head = temp;
    		return head;
    	}
    	
    	ListNode b = head.next;
    	while (b != null) {
    		if (b.val == val) {
    			a.next = b.next;
    			b.next = null;
    			break;
    		}
    		else {
    			a = b;
    			b = b.next;
    		}
    	}
    	
    	return head;
    }
}

//µ¥Ö¸Õë
class Solution182 {
    public static ListNode deleteNode(ListNode head, int val) {
    	if (head == null) {
    		return null;
    	}
    	else if (head.val == val) {
    		ListNode temp = head.next;
    		head.next = null;
    		head = temp;
    		return head;
    	}
    	
    	ListNode temp = head;
    	while (temp.next != null) {
    		if (temp.next.val == val) {
    			temp.next = temp.next.next;
    			break;
    		}
    		temp = temp.next;
    	}
    	
    	return head;
    }
}