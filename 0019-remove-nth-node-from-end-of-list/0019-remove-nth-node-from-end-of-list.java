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
        if(head == null){
            return head;
        }
        ListNode node = head;
        int length = getSize(head);

        for(int i = 0; i<length-n-1; i++){
            node = node.next;
        }
        if(length -n == 0){
            head = head.next;
            return head;
        }
        if(node.next != null){
        node.next = node.next.next;
        }
        return head;
    }

        public int getSize(ListNode head){
            int size = 0;
            ListNode temp = head;

            while(temp != null){
                size++;
                temp = temp.next;
            }
            return size;
        }
    
}