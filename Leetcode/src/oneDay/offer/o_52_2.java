package oneDay.offer;

//r
//双指针遍历两遍法
//优化 不管找没找到直接输出即可
public class o_52_2 {
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		
		ListNode tempA = headA;
		ListNode tempB = headB;
		while (tempA != tempB) {
			tempA = tempA.next;
			tempB = tempB.next;
			
			if (tempA == tempB) {
				break;
			}
			
			if (tempA == null) {
				tempA = headB;
			}
			if (tempB == null) {
				tempB = headA;
			}
	
		}
		
		
		return tempA;
    }
	
	public static void main(String[] args) {
//		int skipA = 2, skipB = 3;
//
//		int[] listA = {4,1,8,4,5};
//		int[] listB = {5,0,1,8,4,5};
//		
//		//创建两个链表
//		ListNode headA = new ListNode(listA[0]);
//		ListNode tempA = headA;
//		for (int i = 1; i < skipA; i++) {
//			ListNode j = new ListNode(listA[i]);
//			tempA.next = j;
//			tempA = tempA.next;
//		}
//		
//		ListNode headB = new ListNode(listB[0]);
//		ListNode tempB = headB;
//		for (int i = 1; i < skipB; i++) {
//			ListNode j = new ListNode(listB[i]);
//			tempB.next = j;
//			tempB = tempB.next;
//		}
//		
//		if (skipA < listA.length) {
//			ListNode headAll = new ListNode(listA[skipA]);
//			ListNode temp = headAll;
//			for (int i = skipA + 1; i < listA.length; i++) {
//				ListNode j = new ListNode(listA[i]);
//				temp.next = j;
//				temp = temp.next;
//			}
//			
//			tempA.next = headAll;
//			tempB.next = headAll;
//		}
//		
//		
//		
//		System.out.println(getIntersectionNode(headA, headB));
		
		int skipA = 0, skipB = 0;

		int[] listA = {1};
		int[] listB = {1};
		
		//创建两个链表
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