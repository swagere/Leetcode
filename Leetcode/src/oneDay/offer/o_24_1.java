package oneDay.offer;

//�ݹ�
public class o_24_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Solution241 {
	ListNode newHead = new ListNode(-1);
    public ListNode reverseList(ListNode head) {
    	recur(head);
    	return newHead.next;
    }
    
    public ListNode recur(ListNode cur) {
    	if (cur == null) {
    		return newHead;
    	}
    	
    	ListNode node = recur(cur.next);
    	node.next = new ListNode(cur.val);
    	node = node.next;
    	return node;
    }
}

//�Ż� ��������ԭ����������ͬ�Ľڵ� ֻ����һ���ڵ�
class Solution2411 {
	ListNode newHead = new ListNode(-1);
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
    	recur(head);
    	head.next = null;
    	return newHead.next;
    }
    
    public ListNode recur(ListNode cur) {
    	if (cur.next == null) {
    		newHead.next = cur;
    		return cur;
    	}
    	
    	ListNode node = recur(cur.next);
    	node.next = cur;
    	return node.next;
    }
}