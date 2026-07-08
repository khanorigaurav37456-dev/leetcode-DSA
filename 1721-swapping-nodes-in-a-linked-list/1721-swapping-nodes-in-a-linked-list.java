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
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null){
            return head;
        }
        ListNode permanent = head;
        for(int i =0; i<k-1; i++){
            permanent = permanent.next;
        }
        ListNode first = permanent;
        ListNode second = head;

        while(first.next != null){
            first = first.next;
            second = second.next;
        }

        int temp = permanent.val;
        permanent.val = second.val;
        second.val = temp;

        return head;
    }
}