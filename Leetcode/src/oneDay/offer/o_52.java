package oneDay.offer;

public class o_52 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//双指针 双重循环
class Solution521 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        ListNode res = null;
        while (t1 != null) {
        	t2 = headB;
        	while (t2 != null) {
        		if (t1.val == t2.val) {
        			ListNode tt1 = t1;
        			ListNode tt2 = t2;
        			while (tt1.val == tt2.val && tt1 != null) {
        				tt1 = tt1.next;
        				tt2 = tt2.next;
        			}
        			if (tt1 == null && tt2 == null) {
        				res = t1;
        				t1 = tt1;
        				t2 = tt2;
        				break;
        			}
        		}
        		t2 = t2.next;
        	}
        	if (t1.val == t2.val && t1 == null) {
    			break;
    		}
        	t1 = t1.next;
        }
        return res;
    }
}

//从末尾开始寻找
