/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return head;
        }
        Node current = head;
        Node copyList = new Node(current.val);
        Node temp = copyList;
        current = current.next;
        while(current != null){
        Node newNode = new Node(current.val);
        temp.next = newNode;
        temp = temp.next;
        current = current.next;
        
        }
        Node originalCurrent = head;
        Node copyCurrent = copyList;

        while(originalCurrent != null){

        if(originalCurrent.random == null){
            copyCurrent.random = null;
        } 

        Node p1 = head;
        Node p2 = copyList;
        

        while(p1 != originalCurrent.random){
            p1 = p1.next;
            p2 = p2.next;
        } 
            copyCurrent.random = p2;
        
         originalCurrent = originalCurrent.next;
    copyCurrent = copyCurrent.next;
        
        

        }
        return copyList;
        
    }
}