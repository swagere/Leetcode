package oneDay.offer;

public class o_22 {

	public static void main(String[] args) {

	}

}
//µ•÷∏’Î
class Solution221 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
    	ListNode temp = head;
    	int len = 0;
    	while (temp != null) {
    		temp = temp.next;
    		len += 1;
    	}
    	int count = 0;
    	temp = head;
    	while (count < len - k) {
    		temp = temp.next;
            count += 1;
    	}
    	return temp.next;
    }
}

//À´÷∏’Î
class Solution222 {
    public static ListNode getKthFromEnd(ListNode head, int k) {
    	ListNode fast = head;
    	ListNode slow = head;
    	int count = 0;
    	while (fast.next != null) {
    		if (count < k) {
    			count += 1;
    		}
    		else {
    			slow = slow.next;
    		}
    		fast = fast.next;
    	}
    	return slow;
    }
}
