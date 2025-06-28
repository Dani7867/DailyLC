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
    int length = 0;
    ListNode temp = head;

    // Step 1: Calculate length
    while (temp != null) {
        length++;
        temp = temp.next;
    }

    // Step 2: Edge case — remove head
    if (n == length) {
        return head.next;
    }

    // Step 3: Find (length - n)th node
    temp = head;
    for (int i = 0; i < length - n - 1; i++) {
        temp = temp.next;
    }

    // Step 4: Remove the node
    temp.next = temp.next.next;

    return head;
}
}