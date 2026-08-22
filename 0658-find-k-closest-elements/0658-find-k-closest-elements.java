class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) ->{
            int distanceA = Math.abs(a-x);
            int distanceB = Math.abs(b-x);

            if(distanceA != distanceB){
                return Integer.compare(distanceB,distanceA);
            }
            return Integer.compare(b,a);
        });

        for(int num : arr){
            maxHeap.offer(num);

            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!maxHeap.isEmpty()){
            list.add(0, maxHeap.poll());
        }
        Collections.sort(list);
        return list;
    }
}