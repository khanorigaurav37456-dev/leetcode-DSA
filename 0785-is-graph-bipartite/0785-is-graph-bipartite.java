class Solution {
    boolean res = true;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];
        Arrays.fill(colors,-1);

        for(int j = 0; j<n; j++){
            if(colors[j] == -1){
                dfs(graph,j,0,colors);
            }
        }
        return res;
    }
    void dfs(int[][] graph, int node, int c,int[] colors){
        colors[node] = c;

        for(int i=0; i<graph[node].length; i++){
            int neigh = graph[node][i];

            if(colors[neigh] != -1 && colors[neigh] == c){
                res = false;
            }
            if(colors[neigh] == -1){
                dfs(graph,neigh,1-c,colors);
            }
        }
    }
}