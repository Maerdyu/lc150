/**
 * 92. 反转链表 II
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode first = new ListNode(0, head);
		int i = 1;
		ListNode res = first;
		while (i < left) {
			res = res.next;
			i++;
		}

		ListNode reverse = res.next;
		ListNode node = reverse, temp = reverse;
		while (i < right && reverse.next != null) {
			node = reverse.next;
			reverse.next = reverse.next.next;
			node.next = temp;
			temp = node;
			i++;
		}
		res.next = node;
		return first.next;
	}

	public static void main(String[] args) {
		ListNode node5 = new ListNode(5);
		ListNode node4 = new ListNode(4, node5);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);

		ReverseBetween reverseBetween = new ReverseBetween();
		ListNode node = reverseBetween.reverseBetween(node1, 2, 4);
		while (node != null){
			System.out.println(node.val);
			node = node.next;
		}
	}
}
