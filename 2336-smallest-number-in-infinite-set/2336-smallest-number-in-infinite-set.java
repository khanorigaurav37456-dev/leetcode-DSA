class SmallestInfiniteSet {
    HashSet<Integer> set;
    PriorityQueue<Integer> heap;
    int small;

    public SmallestInfiniteSet() {
        set = new HashSet<>();
        heap = new PriorityQueue<>();
        small = 1;
    }
    
    public int popSmallest() {
        int num;
       if(!heap.isEmpty()){
         num = heap.poll();
         set.remove(num);
       } else{
        num = small;
        small++;
       }
       return num;
    }
    
    public void addBack(int num) {
        if(!set.contains(num) && num < small){
            if(num == small - 1){
                small--;
                //set.add(num);
            } else{
                heap.offer(num);
                set.add(num);
            }
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */