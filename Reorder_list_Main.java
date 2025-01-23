// https://leetcode.com/problems/reorder-list/description/
/*
 * You are given the head of a singly linked-list. The list can be represented
 * as:
 * 
 * L0 → L1 → … → Ln - 1 → Ln 
 * Reorder the list to be on the following form:
 * 
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → … 
 * You may not modify the values in the
 * list's nodes. Only nodes themselves may be changed.
 */

/*
 * proper logic 
 * time complexity : O(n) 
 * Space Complexity : O(1)
 * 
 */

public class Reorder_list_Main {

	public static void reorderList(ListNode head) {
		if (head.next == null) {
			return;
		}

		ListNode slow = head;
		ListNode fast = head;
		// find mid node
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// reverse the list from midnode.next and set midnode.next = null ( here fast
		// var represents as secondNode )
		fast = slow.next;
		slow.next = null;
		fast = reverse(fast);

		// merge the two linked list
		ListNode newList = new ListNode();
		slow = newList;
		while (head != null && fast != null) {
			slow.next = head;
			head = head.next;

			slow = slow.next;
			slow.next = fast;
			fast = fast.next;

			slow = slow.next;

		}

		if (head != null) {
			slow.next = head;
		}
		else {
			slow.next = fast;
		}

		head = newList.next;
	}

	public static ListNode reverse(ListNode node) {
		if (node == null) {
			return node;
		}

		ListNode prev = null;
		ListNode curr = node;
		ListNode next = node.next;

		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.next;
			}
		}

		return prev;
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
		Reorder_list_Main.ListNode list = new Reorder_list_Main.ListNode(1);
		list.next = new ListNode(2);
		// list.next.next = new ListNode(3);
		// list.next.next.next = new ListNode(4);
		// list.next.next.next.next = new ListNode(5);

		display(list);
		reorderList(list); // index start from 1
		System.out.println("LinkedLIst after reorder");
		display(list);
	}

	static class ListNode {
		int val;
		ListNode next;

		// Constructor to initialize the node with a value
		ListNode(int val) {
			this.val = val;
			this.next = null;
		}

		// Default constructor
		ListNode() {
			this.val = 0;
			this.next = null;
		}
	}
}
