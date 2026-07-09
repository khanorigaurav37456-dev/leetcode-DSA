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
    public int pairSum(ListNode head) {
        int max = 0;
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode p1 = head;
        ListNode p2 = reverseList(slow);

        while(p1 != null && p2 != null){
            max = Math.max(p1.val + p2.val,max);
            p1 = p1.next;
            p2 = p2.next;
        }
        return max;

    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
    return null;
}
        ListNode prev = null;
        ListNode pres = head;
        ListNode next = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = next;
            if(next != null) {
                next = next.next;
            }
        }
        return prev;
    }
}