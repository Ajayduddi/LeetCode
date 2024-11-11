// https://leetcode.com/problems/add-two-numbers/description/

/**
 * Definition for singly-linked list.
 */
 function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
 }
 

 
/**
 * solution using iterartion
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers = function(l1, l2) {
    let dummy = new ListNode(0, null);
    let node = dummy;
    let num = 0;

    while( l1 != null || l2 != null || num > 0){
        if(l1 != null){
            num += l1.val;
            l1 = l1.next;
        }

        if(l2 != null){
            num += l2.val;
            l2 = l2.next;
        }

        node.next = new ListNode(num % 10);
        node = node.next;
        num = Math.floor(num / 10);

    }

    // print the list
    node = dummy.next;
    while(node != null){
        console.log(node.val);
        node = node.next;
    }

    // return dummy.next;
};



/**
 * solution using recursion
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
var addTwoNumbers_recurssion = function(l1, l2) {
    let dummy = new ListNode(0, null);
    adding(l1,l2,dummy,0);
    
    // print the list
    let node = dummy.next;
    while(node != null){
        console.log(node.val);
        node = node.next;
    }

    // return dummy.next;
};

function adding(l1,l2,node,num){

    // base condition
    if(l1 == null && l2 == null && num == 0){
        return;
    }

    if(l1 != null){
        num += l1.val;
        l1 = l1.next;
    }

    if(l2 != null){
        num += l2.val;
        l2 = l2.next;
    }

    node.next = new ListNode(num % 10);
    node = node.next;
    num = Math.floor(num / 10);

    adding(l1,l2,node,num);
}


// execution
var l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
var l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
addTwoNumbers(l1, l2);
console.log(" ")
addTwoNumbers_recurssion(l1, l2);