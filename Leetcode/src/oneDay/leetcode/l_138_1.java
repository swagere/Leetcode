package oneDay.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//r
//����ѭ����1. һ�α�����ֵȫ����random 2. �ٴα��� �Ƚ�Ѱ��random����ֵ
public class l_138_1 {
	public static Node copyRandomList(Node head) {
		Node node = head; //����ԭ����
		List<Node> list = new ArrayList<>(); //ԭ����
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		
		//��һ��ѭ��
		Node headNode = new Node(-1);
		Node a = headNode;
		for (int i = 0; i < list.size(); i++) {
			Node temp = list.get(i);
			a.next = new Node(temp.val);
			a = a.next;
		}
		headNode = headNode.next;
		
		//�ڶ���ѭ��
		Node t = headNode; //���ڱ��浱ǰѭ��
		while (list.size() > 0) {
			Node tt = list.remove(0);
			Node random = tt.random;
			if (random == null) {
				t.random = null;
			}
			else {
				//�����Ϊ������� �ҵ�t_1��random��ȵ�ʱ��
				Node t_1 = headNode;
				while (t_1 != null) {
					if (t_1.val == random.val) { // ����ҵ���һ��ֵ��random����һ�����
						Node t_11 = t_1.next;
						Node t_r = random.next;
						//��������� �ж��Ƿ�ΪҪ�ҵ�ֵ
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