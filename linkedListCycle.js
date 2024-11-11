// https://leetcode.com/problems/linked-list-cycle/
/*
 * Given 'head', the head of a linked list, determine if the linked list has a cycle in it.
 * we solve this problem by using a slow and fast pointers
 * slow pointer moves one step at a time
 * fast pointer moves two steps at a time
 * if the slow and fast pointers meet at any point, then there is a cycle
 */

/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

function ListNode(val,next) {
    this.val = val;
    this.next = next;
}


/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    if(head == null || head.next == null){
        return false;
    }

    let ans = check(head.next,head.next.next)
    return ans;
};


// using recursion
let check = (slow,fast) =>{
    //base conditions
    if( slow == fast){
        return true;
    }

    if(fast == null){
        return false;
    }

    return check(slow.next, fast?.next?.next);
}

var hasCycle_loop = function(head) {
    let ans = check_loop(head,head)
    return ans;
};

// using iteration
var check_loop = (slow, fast) => { 
    while (fast?.next && fast.next?.next) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow === fast) {
            return true;
        }
    }
    return false;
}

let temp1 = new ListNode(-4);
let temp = new ListNode(2, new ListNode(3, temp1))
temp1.next = temp;

console.log(hasCycle_loop(new ListNode(1, temp1)));