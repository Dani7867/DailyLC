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
    // O(nlog(k)) instead of traditional way O(nlogn)
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val - b.val);
        for (ListNode node : lists) {
            if(node != null){
                pq.offer(node);
            }
        }
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if(minNode.next != null){
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}