class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
         (a, b) -> Integer.compare(a[1], b[1])
        );
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num : nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            } else{
                map.put(num,1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});
            if (minHeap.size() > k) {
                 minHeap.poll();
        }

        }

        int[] arr = new int[k];

        for(int i=0; i<k; i++){
            int[] pair = minHeap.poll();
            arr[i] = pair[0];
        }

        return arr;
    }
}