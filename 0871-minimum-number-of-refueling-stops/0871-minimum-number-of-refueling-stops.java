class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int fuel = startFuel;
        int stops = 0;
        int previousPosition = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int[] station : stations){
            int distance = station[0] - previousPosition;
            fuel = fuel - distance;
            while(fuel <0){
                if(heap.isEmpty()){
                    return -1;
                }
                fuel = fuel + heap.poll();
                stops++;
            }
            heap.offer(station[1]);
            
            previousPosition = station[0];
        }
        int distance = target - previousPosition;
        fuel = fuel - distance;
        while(fuel < 0){
            if(heap.isEmpty()){
                    return -1;
                }
            fuel = fuel + heap.poll();
            stops++;
        }

        return stops;
    }
}