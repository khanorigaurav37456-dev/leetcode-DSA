class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i<stones.length; i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size() >= 2){
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if(x == y){
                continue;
            } else {
                y = x-y;
                maxHeap.add(y);
            }
        }
        if(maxHeap.isEmpty()){
            return 0;
        } else{
            return maxHeap.peek();
        }

    }
}