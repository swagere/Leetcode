package oneDay.offer;

import java.util.Stack;

public class o_52 {

	public static void main(String[] args) {
		ListNode A = new ListNode(-1);
		int[] a = new int[] {1,3};
		ListNode B = new ListNode(-1);
		int[] b = new int[] {};
		
		ListNode temp = A;
		for (int i = 0; i < a.length; i++) {
			temp.next = new ListNode(a[i]);
			temp = temp.next;
		}
		
		temp = B;
		for (int i = 0; i < b.length; i++) {
			temp.next = new ListNode(b[i]);
			temp = temp.next;
		}
		
		System.out.println(Solution523.getIntersectionNode(A.next, B.next));

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
        		if (t1 == t2) {
        			ListNode tt1 = t1;
        			ListNode tt2 = t2;
        			while (tt1 != null && tt1 == tt2) {
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
        	if (t1 == null && t2 == null) {
    			break;
    		}
        	t1 = t1.next;
        }
        return res;
    }
}

//先存到栈中，再从末尾开始比较
//反向查找+栈
class Solution522 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	Stack<ListNode> s1 = new Stack<>();
    	Stack<ListNode> s2 = new Stack<>();
        ListNode temp = headA;
        while (temp != null) {
        	s1.push(temp);
        	temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
        	s2.push(temp);
        	temp = temp.next;
        }
        
        ListNode res = null;
        while (s1.size() > 0 && s2.size() > 0) {
        	if (s1.peek() == s2.peek()) {
        		s1.pop();
        		s2.pop();
        	}
        	else {
        		res = s1.pop();
        		break;
        	}
        }
        
        if (s1.size() == 0 && s2.size() == 0) {
        	return headA;
        }
        else if (s1.size() == 0) {
        	return s2.pop().next;
        }
        else if (s2.size() == 0) {
        	return s1.pop().next;
        }
        
        return res.next;
    }
}

//双指针
class Solution523 {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA;
        ListNode t2 = headB;
        while (t1 != t2) {
        	if (t1 == null) {
        		t1 = headB;
        	}
        	else {
        		t1 = t1.next;
        	}
        	if (t2 == null) {
        		t2 = headA;
        		continue;
        	}
        	else {
        		t2 = t2.next;
        	}
        }
        return t2;
    }
}
