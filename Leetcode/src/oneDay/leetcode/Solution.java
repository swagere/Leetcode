package oneDay.leetcode;

class Solution {
    public static ListNode[] splitListToParts(ListNode head, int k) {
    	ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len += 1;
        }

        int t = 0;
        if (len % k == 0) {
            t = len / k;
        }
        else {
            t = len / k + 1;
        }

        temp = head;
        ListNode[] res = new ListNode[k];
        res[0] = head;
        int index = 1;
        while (len > 0) {
        	for (int i = 1; i < t && temp != null; i++) {
        		temp = temp.next;
        	}
        	
            if (temp != null) {
            	len -= t;
                ListNode r = temp.next;
                if (r != null) {
                	temp.next = null;
                    res[index] = r;
                    temp = r;
                    
                    index += 1;
                    if (len % (k - index + 1) == 0) {
                        t = len / (k - index + 1);
                    }
                }
                
            }
        	
        }
        return res;
    }
    
    public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode temp = head;
		for (int i = 2; i < 8; i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}
		int k = 3;
		System.out.println(splitListToParts(head, k).toString());
	}
}


class ListNode {
	int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     
     @Override
 	public String toString() {
 		return "ListNode [val=" + val + ", next=" + next + "]";
 	}
 }
 