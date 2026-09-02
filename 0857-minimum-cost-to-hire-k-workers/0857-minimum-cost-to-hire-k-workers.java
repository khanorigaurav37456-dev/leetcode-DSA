class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int[][] worker = new int[quality.length][2];

        for(int i =0; i<quality.length; i++){
            worker[i][0] = quality[i];
            worker[i][1] = wage[i];
        }

        Arrays.sort(worker,(a,b)-> Double.compare(
            (double) a[1]/a[0],
            (double) b[1]/b[0]
        ));

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        for(int[] w : worker){
            totalQuality += w[0];
            heap.offer(w[0]);
        
        if(heap.size()>k){
            totalQuality -= heap.poll();
        }
        if(heap.size() == k){
            double ratio = (double) w[1] / w[0];
            double cost = totalQuality * ratio;
            minCost = Math.min(cost,minCost);  
        
        }

        }
        return minCost;

    }
}