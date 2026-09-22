class Solution {
    public int networkDelayTime(int[][] times, int n, int src) {
        ArrayList<int[]>[] graph = new ArrayList[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int weig = time[2];
            
            graph[u-1].add(new int[] {v-1,weig});
            
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int[] distance = new int[n];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[src-1] = 0;
        heap.offer(new int[]{distance[src-1],src-1});
        while(!heap.isEmpty()){
            int[] pair = heap.poll();
            int d = pair[0];
            int node = pair[1];
            if(d > distance[node]){
                continue;
            }
            for(int j =0; j<graph[node].size(); j++){
                int[] edge = graph[node].get(j);
                int neigh = edge[0];
                int weight = edge[1];
                if(d + weight < distance[neigh]){
                    distance[neigh] = d + weight;
                    heap.offer(new int[]{d+weight,neigh});
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for(int d:distance){
            if(d == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,d);
        }

        return max;
        
    }
}