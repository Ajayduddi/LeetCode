// https://leetcode.com/problems/linked-list-cycle-ii/

/*
 * Given the head of a linked list, return the node where the cycle begins. If
 * there is no cycle, return null.
 * 
 * To detect the cycle in the linked list, we use fast and slow pointer method.
 * if cycle ins present find the length of the cycle
 * 
 * to detect the cycle begning we use another two pointers. first pointer &
 * second pointer. jump the second pointer from starting position to length of
 * cycle.
 * 
 * After that move the first & second pointer to next node. where the first ==
 * second then it is the place where cycle begins.
 * 
 * https://www.youtube.com/watch?v=70tx7KcMROc&t=3600s
 * 
 */

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedList_Cycle_II {

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode node = new ListNode(2);
        head.next = node;
        // head.next.next = node;
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(-4);
		head.next.next.next.next = node;

        ListNode cycle = detectCycle(head);
		if(cycle != null){
            System.out.println("Cycle is present and begins at node: " + cycle.val);
		}else{
			System.out.println("Cycle is not present");
		}
	}

	static public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean cycle = false;
        int length = 0;

        // slow and fast pointer to detect the cycle
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            // if slow == fast then cycle is present
            if(slow == fast){
                cycle = true;
                ListNode temp = slow;
                // find length of cycle
                do{
                    length++;
                    temp = temp.next;
                } while (temp != slow);
                break;
            }
        }

        // if cycle is not present
        if(cycle == false){
            return null;
        }

        slow = head; // act like second
        fast = head; // act like first

        // jump the second pointer from statrting position to length of cycle
        for (int i = 0; i < length; i++) {
            slow = slow.next;
        }

        // move the first & second pointer to next node. where the first == second
        // then it is the place where cycle begins
        while(fast != slow){
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}