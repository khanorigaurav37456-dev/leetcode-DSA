class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int[][] pairs = new int[nums1.length][2];

        for(int i=0; i<nums1.length; i++){
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs,(a,b) -> Integer.compare(b[1],a[1]));

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        long sum = 0;
        long maxScore = 0;

        for(int j = 0; j < pairs.length; j++){
            heap.offer(pairs[j][0]);
            sum += pairs[j][0];

            if(heap.size() > k){
                sum = sum - heap.poll();
            }
            if(heap.size() == k){
                long score = sum * pairs[j][1];
                maxScore = Math.max(maxScore,score);
            }
        }
        return maxScore;
    }
}