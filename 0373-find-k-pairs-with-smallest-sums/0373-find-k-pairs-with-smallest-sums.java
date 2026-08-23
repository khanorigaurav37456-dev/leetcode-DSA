class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<>();

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) ->{
            return Integer.compare(
                nums1[a[0]] + nums2[a[1]],
                nums1[b[0]] + nums2[b[1]]
            );
        });

        for(int row = 0; row<nums1.length; row++){
            minHeap.offer(new int[]{row,0});
        }

        for(int i = 0; i<k && !minHeap.isEmpty();i++){
            int[] current = minHeap.poll();
            int row = current[0];
            int col = current[1];
            list.add(Arrays.asList(nums1[row], nums2[col]));

            if(col + 1 < nums2.length){
                minHeap.offer(new int[]{row,col+1});
            }
        }
        return list;

    }
}