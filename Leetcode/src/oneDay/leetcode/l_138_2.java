package oneDay.leetcode;

import java.util.HashMap;
import java.util.Map;

//r
//ԭ���㷨��1. ֱ����ԭ����ڵ�������ڵ� ����ȷ��ֵ 2. ����������ֿ�
public class l_138_2 {
	public static Node copyRandomList(Node head) {
		Node node = head; //����ԭ����
		
		//����½ڵ�
		while (node != null) {
			Node newNode = new Node(node.val);
			newNode.next = node.next;
			node.next = newNode;
			
			node = node.next.next;
		}
		
		//�����½ڵ��random��
		node = head;
		int index = 1;
		while (node != null) {
			if (index % 2 != 0) { //ԭ����
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
		
		//������������
		Node newHead = new Node(-1);
		Node temp = newHead;
		node = head;
		while (node != null) {
			temp.next = node.next;
			node.next = node.next.next;
			
			//����
			temp = temp.next;
			node = node.next;
		}
		
		return newHead.next;
	}
	
	//�������е�����
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
			
			//������� �γ�����
			temp.next = cur;
			temp = temp.next;
		}
		
	
		System.out.println(copyRandomList(headNode));

	}

}