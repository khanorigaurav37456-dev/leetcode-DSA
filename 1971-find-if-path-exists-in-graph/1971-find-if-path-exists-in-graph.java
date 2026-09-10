class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Integer>[] graph = new ArrayList[n];

        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }
        boolean[] visited = new boolean[graph.length];

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        while(!queue.isEmpty()){
            int temp = queue.poll();
            if(temp == destination){
                return true;
            }
            for(int num : graph[temp]){
                if(!visited[num]){
                queue.offer(num);
                }
                visited[num] = true;
            }
        }
        return false;
    }
}