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
    public ListNode modifiedList(int[] nums, ListNode temp) {
        if (temp == null) return null;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = temp;
        ListNode current = dummy;

        while (current != null && current.next != null) {
            if (numSet.contains(current.next.val)) {
                current.next = current.next.next; 
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
}
// tle
// class Solution {
//     public ListNode modifiedList(int[] nums, ListNode temp) {
//         ListNode dummy = new ListNode(0);
//         dummy.next = temp;
//         ListNode current = dummy;

//         while (current != null && current.next != null) {
//             boolean found = false;
//             for (int n : nums) {
//                 if (current.next.val == n) {
//                     current.next = current.next.next; 
//                     found = true;
//                     break; 
//                 }
//             }
//             if (!found) {
//                 current = current.next;
//             }
//         }

//         return dummy.next;
//     }
// }
