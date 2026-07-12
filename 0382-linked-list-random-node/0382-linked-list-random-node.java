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
    ListNode savedHead;
    int size; 

    public Solution(ListNode head) {
        savedHead = head;

        size = 0;

        ListNode temp = head;

        while(temp!=null){
            size++;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(size);

        ListNode temp = savedHead;

        for(int i = 0; i<index; i++){
            temp = temp.next;
        }
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */