class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       
       ArrayList<int[]>[] graph = new ArrayList[n];

       for(int i=0; i<n; i++){
        graph[i] = new ArrayList<>();
       }

       for(int[] flight : flights){
        int from = flight[0];
        int to = flight[1];
        int price = flight[2];

        graph[from].add(new int[]{to,price});
       }
       PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
       int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
           Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src][0] = 0;
       minheap.offer(new int[]{0,src,0});

       while(!minheap.isEmpty()){
        int[] current = minheap.poll();

        int cost = current[0];
        int city = current[1];
        int flightsTaken = current[2];

        if (cost > dist[city][flightsTaken]) {
    continue;
}

        if(city == dst){
            return cost;
        }

        if(flightsTaken == k+1){
            continue;
        }

        for(int[] flight : graph[city]){
            int neighbor = flight[0];
            int flightCost = flight[1];

            int newCost = cost + flightCost;
            int newFlightsTaken = flightsTaken + 1;

            if (newCost < dist[neighbor][newFlightsTaken]) {
    dist[neighbor][newFlightsTaken] = newCost;

    minheap.offer(new int[]{
        newCost, neighbor, newFlightsTaken
    });
}
        }
       }
       return -1;
    }
}