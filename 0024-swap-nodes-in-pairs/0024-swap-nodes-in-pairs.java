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
    public ListNode swapPairs(ListNode head) {
        if( head == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;

        while(true) {
            ListNode temp = current;

             for (int i = 0; i < 2; i++) {
                if (temp == null) {
                return head;   // Less than k nodes left
    }
                 temp = temp.next;
}

            ListNode last = previous;
            ListNode newEnd = current;

            // reverse between left and right
            ListNode next = current.next;
            for (int i = 0; current != null && i < 2; i++) {
                current.next = previous;
                previous = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }
            if (last != null) {
                last.next = previous;
            } else {
                head = previous;
            }
            newEnd.next = current;
            if (current == null){
                break;
            }
            previous = newEnd;
        }
        return head;

    }
}