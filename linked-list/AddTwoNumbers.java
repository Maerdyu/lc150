/**
 * 2. 两数相加
 * https://leetcode.cn/problems/add-two-numbers/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class AddTwoNumbers {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode();
		ListNode first = listNode;
		int flag = 0;
		while (l1 != null && l2 != null) {
			int i = l1.val + l2.val + flag;
			int val = i % 10;
			first.next = new ListNode(val);
			flag = i / 10;
			l1 = l1.next;
			l2 = l2.next;
			first = first.next;
		}

		while (l1 != null) {
			int i = l1.val + flag;
			int val = i % 10;
			first.next = new ListNode(val);
			flag = i / 10;
			l1 = l1.next;
			first = first.next;
		}

		while (l2 != null) {
			int i = l2.val + flag;
			int val = i % 10;
			first.next = new ListNode(val);
			flag = i / 10;
			l2 = l2.next;
			first = first.next;
		}

		if(flag !=0 ){
			first.next = new ListNode(flag);
		}

		return listNode.next;
	}

	public static void main(String[] args) {

		AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
		ListNode listNode1 = new ListNode(9);
		ListNode listNode2 = new ListNode(9, listNode1);
		ListNode listNode3 = new ListNode(9, listNode2);


		ListNode listNode4 = new ListNode(9);
		ListNode listNode5 = new ListNode(9, listNode4);
		ListNode listNode6 = new ListNode(9, listNode5);
		ListNode listNode7 = new ListNode(9, listNode6);

		ListNode listNode = addTwoNumbers.addTwoNumbers(listNode3, listNode7);
		while (listNode != null) {
			System.out.println(listNode.val);
			listNode = listNode.next;
		}
	}
}
