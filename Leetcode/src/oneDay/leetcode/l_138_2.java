package oneDay.leetcode;

import java.util.HashMap;
import java.util.Map;

//r
//原地算法：1. 直接在原链表节点后新增节点 并正确赋值 2. 将两个链表分开
public class l_138_2 {
	public static Node copyRandomList(Node head) {
		Node node = head; //遍历原链表
		
		//添加新节点
		while (node != null) {
			Node newNode = new Node(node.val);
			newNode.next = node.next;
			node.next = newNode;
			
			node = node.next.next;
		}
		
		//加上新节点的random域
		node = head;
		int index = 1;
		while (node != null) {
			if (index % 2 != 0) { //原链表
				if (node.random != null) {
					node.next.random = node.random.next;
				}
				else {
					node.next.random = null;
				}
			}
			
			index++;
			node = node.next;
		}
		
		//分离两个链表
		Node newHead = new Node(-1);
		Node temp = newHead;
		node = head;
		while (node != null) {
			temp.next = node.next;
			node.next = node.next.next;
			
			//后移
			temp = temp.next;
			node = node.next;
		}
		
		return newHead.next;
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