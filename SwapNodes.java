// https://leetcode.com/problems/swap-nodes-in-pairs/description/

public class SwapNodes {
	/**
	 * Definition for singly-linked list.
	 *  public class ListNode { 
	 * 		int val; 
	 * 		ListNode next;
	 * 	 	ListNode() {} 
	 * 		ListNode(int val) { this.val = val; } 
	 * 		ListNode(int val, ListNode next) { this.val = val; this.next = next; } }
	 */

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

	static public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode nextNode = head.next;
		ListNode res = swapPairs(head.next.next);
		head.next = res;
		nextNode.next = head;
		return nextNode;

	}

	public static void main(String[] args) {
		SwapNodes main = new SwapNodes();
		ListNode head = main.new ListNode(3);
		head.next = main.new ListNode(0);
		head.next.next = main.new ListNode(-4);
		head.next.next.next = main.new ListNode(-2);

		ListNode temp = swapPairs(head);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
		
	}
}