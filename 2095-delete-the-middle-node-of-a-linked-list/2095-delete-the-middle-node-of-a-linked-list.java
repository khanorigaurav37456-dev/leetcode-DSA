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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null){
            return head;
        }
        if(head.next == null){
            head = head.next;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = slow;
        //ListNode removeNode = prev;
        while(fast !=null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev.next != null){
        prev.next = prev.next.next;
        }

        return head;
        
    }
}