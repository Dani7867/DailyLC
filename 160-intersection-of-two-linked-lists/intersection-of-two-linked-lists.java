/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tA = headA , tB = headB;
        while(tA!=tB){
            tA = (tA==null) ? headB : tA.next;
            tB = (tB==null) ? headA : tB.next;
        }
        return tA;
    }
}