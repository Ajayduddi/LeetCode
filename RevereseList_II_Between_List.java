// https://leetcode.com/problems/reverse-linked-list-ii/

/*
 * Given the head of a singly linked list and two integers left and right where
 * left <= right, reverse the nodes of the list from position left to position
 * right, and return the reversed list.
 */

public class RevereseList_II_Between_List {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            if (count == left) {
                if (prev != null) {
                    prev.next = helper(curr, prev, right, count, curr);
                    break;
                }
                else {
                    return helper(curr, prev, right, count, curr);
                }
            }
            prev = curr;
            curr = curr.next;
        }

        return head;
    }

    public static ListNode helper(ListNode node, ListNode prev, int right, int count, ListNode start) {
        // base condition
        if (count > right) {
            start.next = node;
            start = prev;
            return start;
        }

        ListNode next = node.next;
        node.next = prev;
        return helper(next, node, right, count + 1, start);

    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + "-->");
            temp = temp.next;
        }
        System.out.println("End");
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);

        display(list);
        list = reverseBetween(list, 1, 4); // index start from 1
        System.out.println("LinkedLIst after Reverse");
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

/*
 * Example 1:
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 * 
 * Example 2:
 * Input: head = [5], left = 1, right = 1 
 * Output: [5]
 */