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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;
    
    for(int i = 1 ; i<=n ; i++){
        slow = slow.next;
    }
    if(slow == null) return head.next;
    while(slow!=null && slow.next!=null){
        slow = slow.next;
        fast=fast.next;
    }

    fast.next =fast.next.next;
    return head;
}
}