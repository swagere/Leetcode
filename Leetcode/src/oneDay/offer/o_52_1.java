package oneDay.offer;

//˫ָ�� 
//B��A��������һֱ���� 
//ʱ�临�Ӷ�Ϊ O(n^2)
//r
public class o_52_1 {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode tempA = headA;
		ListNode tempB = headB;
		while (tempA != null) {
			while (tempB != null && tempB != tempA) {
				tempB = tempB.next;
			}
			
			if (tempB != null) {
				while (tempA != null && tempA == tempB) {
					return tempB; //һ���ҵ��ͷ���
				}
			}
			else {
				tempA = tempA.next;
				tempB = headB;
			}
			//�����ٸ���tempA ��Ϊ�����һ����Ⱦͱ�Ȼ�ҵ����
		}
		
		
		return null;
    }
	public static void main(String[] args) {
		int skipA = 3, skipB = 2;

		int[] listA = {2,6,4};
		int[] listB = {1,5};
		
		//������������
		ListNode headA = new ListNode(listA[0]);
		ListNode tempA = headA;
		for (int i = 1; i < skipA; i++) {
			ListNode j = new ListNode(listA[i]);
			tempA.next = j;
			tempA = tempA.next;
		}
		
		ListNode headB = new ListNode(listA[0]);
		ListNode tempB = headB;
		for (int i = 1; i < skipB; i++) {
			ListNode j = new ListNode(listB[i]);
			tempB.next = j;
			tempB = tempB.next;
		}
		
		if (skipA < listA.length) {
			ListNode headAll = new ListNode(listA[skipA]);
			ListNode temp = headAll;
			for (int i = skipA + 1; i < listA.length; i++) {
				ListNode j = new ListNode(listA[i]);
				temp.next = j;
				temp = temp.next;
			}
			
			tempA.next = headAll;
			tempB.next = headAll;
		}
		
		
		
		System.out.println(getIntersectionNode(headA, headB));
	}
}
