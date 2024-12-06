// https://leetcode.com/problems/reverse-nodes-in-k-group/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ReverseNodes_KGroups {

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

	public static void main(String[] args) {
		ReverseNodes_KGroups main = new ReverseNodes_KGroups();
		ListNode head = main.new ListNode(3);
		head.next = main.new ListNode(0);
		head.next.next = main.new ListNode(-4);
		head.next.next.next = main.new ListNode(-2);

		ListNode temp = reverseKGroup(head,3);
		while (temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}

	}
	
    static public ListNode reverseKGroup(ListNode head, int k) {
        // base condition
        int len = length(head);
        if(head == null || len < k){
            return head;
        }

        // if length is greather than k
        ListNode temp = head;
        int count = 0;
        while(count < k){
            temp = temp.next;
            count++;
        }

        // call recrusion
        ListNode res = reverseKGroup(temp,k);

        // swap nodes
        ListNode prev = res;
        ListNode curr = head;
        ListNode next = head.next;

        count = 0;
        while(count < k){
            curr.next = prev;
            prev = curr;
			curr = next;
            count++;
			if (next == null) {
				break;
			}
            next = next.next;
        }

        // return reverse nodes
        return prev;

    }

    static public int length(ListNode head){
        int length = 0;
        while(head != null){
            length++;
            head = head.next;
        }

        return length;
    }
}