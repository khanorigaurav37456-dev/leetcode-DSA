class MyLinkedList {

    private Node head;
    private Node tail;
    private int size;

    private class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {

        if(index < 0 || index >= size){
            return -1;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.val;
    }
    
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size += 1;
    }
    
    public void addAtTail(int val) {
        if (tail == null){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size){
    return;
}
           if (index == 0){
            addAtHead(val);
            return;
        }
        if (index == size){
            addAtTail(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp = temp.next;
            

        }
        Node node = new Node(val, temp.next);
            temp.next = node;
            size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
    return;
}
        if (index == 0){
             deleteFirst();
             return;
        }
        if(index == size-1){
             deleteLast();
             return;
        }
        Node prev = get2(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        //return val;
        
    }
    public Node get2(int index){
        if(index < 0 || index >= size){
            return null;
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
}

    public void deleteFirst(){
        int val =  head.val;
        head = head.next;
        if (head == null){
            tail = null;
        }
        size--;
       // val = head;
        //return val;
    }
    public void deleteLast(){
        if (size <= 1){
             deleteFirst();
             return;
        }
        Node secondLast = get2(size-2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;
       // return val;
       //val = tail;
       size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */