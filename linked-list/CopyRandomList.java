import java.util.HashMap;

/**
 * 138. 随机链表的复制
 * https://leetcode.cn/problems/copy-list-with-random-pointer/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class CopyRandomList {
	public Node copyRandomList(Node head) {
		Node first = head;
		HashMap<Node, Node> nodeMap = new HashMap<>();
		Node res = new Node(0);
		Node loop = res;
		while (first != null){
			Node node = new Node(first.val);
			loop.next = node;
			nodeMap.put(first, node);
			first = first.next;
			loop = loop.next;
		}

		first = head;
		Node second = res.next;
		while (first != null){
			if(first.random != null){
				second.random = nodeMap.get(first.random);
			}
			first = first.next;
			second = second.next;
		}
		return res.next;
	}

	public static void main(String[] args) {
		CopyRandomList copyRandomList = new CopyRandomList();
		Node node = new Node(1);
		Node node1 = new Node(2);
		node.next = node1;
		node.random = node1;
		node1.random = node1;
		Node node2 = copyRandomList.copyRandomList(node);
		while (node2 != null){
			System.out.println(node2.val + " " + node2.random.val);
			node2 = node2.next;
		}
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
}