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
        int[] arr = toArray(head);
        arr = swapTwo(arr,k);
        return arrayToLinkedList(arr);

        

    }
    public ListNode arrayToLinkedList(int[] arr) {

    if (arr.length == 0) {
        return null;
    }

    ListNode head = new ListNode(arr[0]);
    ListNode temp = head;

    for (int i = 1; i < arr.length; i++) {
        ListNode node = new ListNode(arr[i]);
        temp.next = node;
        temp = node;
    }

    return head;
}
        public int[] toArray(ListNode head){
            int size = getSize(head);
            int[] arr = new int[size];
            int i= 0;
            while(head != null){
                arr[i++] = head.val;
                head = head.next;
            }
            return arr;
        }

        public int[] swapTwo(int[] arr, int k){
            int first = k-1;
            int second = arr.length -k;

           

            int temp = arr[first];
            arr[first] = arr[second];
            arr[second] = temp;

            return arr;
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