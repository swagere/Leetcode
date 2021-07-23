package oneDay.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//r
//两次循环：1. 一次遍历赋值全部除random 2. 再次遍历 比较寻找random并赋值
public class l_138_1 {
	public static Node copyRandomList(Node head) {
		Node node = head; //遍历原链表
		List<Node> list = new ArrayList<>(); //原链表
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		
		//第一遍循环
		Node headNode = new Node(-1);
		Node a = headNode;
		for (int i = 0; i < list.size(); i++) {
			Node temp = list.get(i);
			a.next = new Node(temp.val);
			a = a.next;
		}
		headNode = headNode.next;
		
		//第二遍循环
		Node t = headNode; //用于保存当前循环
		while (list.size() > 0) {
			Node tt = list.remove(0);
			Node random = tt.random;
			if (random == null) {
				t.random = null;
			}
			else {
				//如果不为空则遍历 找到t_1和random相等的时候
				Node t_1 = headNode;
				while (t_1 != null) {
					if (t_1.val == random.val) { // 如果找到下一个值和random的下一个相等
						Node t_11 = t_1.next;
						Node t_r = random.next;
						//遍历到最后 判断是否为要找的值
						while (!(t_11 == null || t_r == null)) {
							t_11 = t_11.next;
							t_r = t_r.next;
						}
						if (t_11 == null && t_r == null) {
							t.random = t_1;
							break;
						}
					}
					t_1 = t_1.next;
				}
			}
			
			
			t = t.next;
		}
		
		return headNode;
	}
	
	//主方法有点问题
	public static void main(String[] args) {
//		int[][] head = {{7,-1},{13,0},{11,4},{10,2},{1,0}};
		int[][] head = {{1,1},{2,1}};
		Node headNode = null;
		Map<Integer, Node> nodes = new HashMap<>();
		if (head.length > 0) {
			headNode = new Node(head[0][0]);
			if (head[0][1] == -1) {
				headNode.random = null;
			}
			else {
				if (head[0][1] > 0) {
					Node t = new Node(head[0][1]);
					nodes.put(head[0][1], t);
					headNode.random = t;
				}
				else {
					headNode.random = headNode;
				}
			}
		}

		Node cur = null;
		Node temp = headNode;
		for (int i = 1; i < head.length; i++) {
			if (nodes.containsKey(i)) {
				cur = nodes.remove(i);
			}
			else {
				cur = new Node(i);
			}
			cur.val = head[i][0];
			
			if (head[i][1] == -1) {
				cur.random = null;
			}
			else {
				if (head[i][1] > 0) {
					Node t = new Node(head[i][1]);
					nodes.put(head[i][1], t);
					cur.random = t;
				}
				else if (head[i][1] == i){
					cur.random = headNode;
				}
				else {
					int index = 0;
					Node r = headNode;
					while (index < head[i][1]) {
						r = r.next;
					}
					
					cur.random = r;
				}
			}
			
			//创建完成 形成链表
			temp.next = cur;
			temp = temp.next;
		}
		
	
		System.out.println(copyRandomList(headNode));

	}

}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

	@Override
	public String toString() {
		return "Node [val=" + val + ", next=" + next + "]";
	}


    
}