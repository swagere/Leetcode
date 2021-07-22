package oneDay.offer;

//双指针 
//B在A的条件下一直遍历 
//时间复杂度为 O(n^2)
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
					return tempB; //一旦找到就返回
				}
			}
			else {
				tempA = tempA.next;
				tempB = headB;
			}
			//不用再更改tempA 因为如果有一个相等就必然找到结果
		}
		
		
		return null;
    }
	public static void main(String[] args) {
		int skipA = 3, skipB = 2;

		int[] listA = {2,6,4};
		int[] listB = {1,5};
		
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
