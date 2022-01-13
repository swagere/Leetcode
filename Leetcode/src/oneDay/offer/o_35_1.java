package oneDay.offer;

//辅助栈
public class o_35_1 {

	public static void main(String[] args) {
		Node head = new Node(7);
		Node n1 = new Node(13);
		Node n2 = new Node(11);
		Node n3 = new Node(10);
		Node n4 = new Node(1);
		head.next = n1;
		head.random = null;
		n1.next = n2;
		n1.random = head;
		n2.next = n3;
		n2.random = n4;
		n3.next = n4;
		n3.random = n2;
		n4.next = null;
		n4.random = head;
		Solution351 s = new Solution351();
		s.copyRandomList(head);
	}

}

class Solution351 {
    public Node copyRandomList(Node head) {
    	if (head == null) {
    		return head;
    	}
        Node temp = head;
        //复制链表 暂不赋值random
        while (temp != null) {
        	Node node = new Node(temp.val);
        	node.next = temp.next;
        	temp.next = node;
        	temp = temp.next.next;
        }
        
        //赋值random
        temp = head;
        while (temp != null && temp.next != null) {
        	if (temp.random == null) {
        		temp.next.random = null;
        		temp = temp.next.next;
        	}
        	else {
	        	temp.next.random = temp.random.next;
	        	temp = temp.next.next;
        	}
        }
        
        //分离
        temp = head;
        Node newHead = new Node(-1);
        Node node = newHead;
        while (temp != null && temp.next != null) {
        	node.next = temp.next;
        	temp.next = temp.next.next;
        	node = node.next;
        	temp = temp.next;
        }
        
        return newHead.next;
    }
}