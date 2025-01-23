// https://leetcode.com/problems/palindrome-linked-list/

/*
 * Given the head of a singly linked list, return true if it is a palindrome or
 * false otherwise.
 *  
 * Example 1: 
 * Input: head = [1,2,2,1] 
 * Output: true
 */

import java.util.ArrayList;

class List_Palindrome {
	public static boolean isPalindrome(ListNode head) {
		if (head.next == null) {
			return true;
		}

		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// list have 2 elements
		if (slow.next == null) {
			if (head.val == slow.val) {
				return true;
			}
			else {
				return false;
			}
		}

		// if list have 3 elements
		if (slow.next == fast) {
			if (head.val == fast.val) {
				return true;
			}
			else {
				return false;
			}
		}

		ArrayList<Integer> arr = new ArrayList<>();
		ListNode temp = head;
		while (temp.next != slow.next) {
			arr.add(temp.val);
			temp = temp.next;
		}

		int i = arr.size() - 1;
		if (fast == null) {
			temp = slow;
		}
		else {
			temp = slow.next;
		}

		while (i >= 0) {
			if (temp.val != arr.get(i)) {
				return false;
			}
			i--;
			temp = temp.next;
		}

		return true;
	}

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(2);
        list.next.next.next.next = new ListNode(1);

		if (isPalindrome(list)) {
			System.out.println("List is plaindrome");
		}
		else {
			System.out.println("List is not a palindrome");
		}
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
