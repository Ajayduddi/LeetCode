/*
 * My logic
 * time complexity : O(n)
 * Space Complexity : O(n)
 * comlplex to understand
 */

public class Reorder_list {
	int count = 0;
	ListNode start;
	ListNode startprev;

	public static void reorderList(ListNode head) {
		if(head.next == null){
            return;
        }

		ListNode last = head;
		Reorder_list obj = new Reorder_list();
		while (last != null) {
			obj.count++;
			last = last.next;
		}

		if (obj.count == 2) {
			return;
		}

		obj.start = head.next;
		obj.startprev = head;
		obj.count = (int) (Math.ceil(((double) obj.count / 2)));
		ListNode list = helper(head.next, head, obj);
	}

	public static ListNode helper(ListNode node, ListNode prev, Reorder_list obj) {
		// base condition
		// this will execute from last of the list
		if (node.next == null) {
			prev.next = null;
			obj.count--;
			return node;
		}

		ListNode last = helper(node.next, node, obj);
		// obj.startprev.next = helper(node.next, node, obj);
		if (obj.count == 0) {
			return null;
		}

		obj.startprev.next = last;
		obj.startprev = obj.startprev.next;
		obj.startprev.next = obj.start;
		obj.startprev = obj.startprev.next;
		obj.start = obj.start.next;
		obj.count--;

		if (obj.count == 0) {
			return null;
		}

		prev.next = null;
		return node;
	}

	public static void display(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + "-->");
			temp = temp.next;
		}
		System.out.println("null");
	}

	public static void main(String[] args) {
		ListNode list = new ListNode(1);
		list.next = new ListNode(2);
		list.next.next = new ListNode(3);
		// list.next.next.next = new ListNode(4);
		// list.next.next.next.next = new ListNode(5);

		display(list);
		reorderList(list); // index start from 1
		System.out.println("LinkedLIst after reorder");
		display(list);
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode() {}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}