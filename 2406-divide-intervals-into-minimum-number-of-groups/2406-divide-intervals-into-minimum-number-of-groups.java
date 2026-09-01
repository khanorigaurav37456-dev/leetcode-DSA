class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for(int[] b : intervals){
            if(!heap.isEmpty() && heap.peek() < b[0]){
                heap.poll();
            }
            heap.offer(b[1]);
        }
        return heap.size();
    }
}