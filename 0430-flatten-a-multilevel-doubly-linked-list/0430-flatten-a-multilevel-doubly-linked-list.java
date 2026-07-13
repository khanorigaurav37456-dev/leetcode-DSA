/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null){
            return null;
        }
        FlattenAndGetTail(head);
        return head;
    }
    private Node FlattenAndGetTail(Node head){
        Node current = head;

        while(current != null){
            if(current.child != null){
                Node oldNext = current.next;

                Node childHead = current.child;

                Node childTail = FlattenAndGetTail(childHead);

                current.next = current.child;
                childHead.prev = current;

                current.child = null;

                childTail.next = oldNext;

                if(oldNext !=null){
                    oldNext.prev = childTail;
                }
            }
            if(current.next == null){
                return current;
            }

            current = current.next;
        }
        return null;
    }
}