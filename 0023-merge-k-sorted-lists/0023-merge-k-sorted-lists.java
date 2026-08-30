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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i = 0; i<lists.length; i++){
            ListNode current = lists[i];

            while(current!=null){
                heap.offer(current.val);
                current = current.next;
            }
        }

            if(heap.isEmpty()){
                return null;
            }

            ListNode head = new ListNode(heap.poll());
            ListNode temp = head;

            while(!heap.isEmpty()){
                temp.next = new ListNode(heap.poll());
                temp = temp.next;
            }

            
        
        return head;
    }
}