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
    public int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int[] ans = new int[len]; 

        ListNode curr1 = head;
        for (int i = 0; i < len; i++) { 
            ListNode curr = curr1.next;
            while (curr != null) {
                if (curr1.val < curr.val) {
                    ans[i] = curr.val;
                    break; 
                }
                curr = curr.next;
            }
            curr1 = curr1.next;
        }
        return ans;
    }
}
