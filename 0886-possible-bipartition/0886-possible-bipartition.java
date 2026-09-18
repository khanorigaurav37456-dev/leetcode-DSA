class Solution {
    boolean res = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] dislike : dislikes){
            int u = dislike[0];
            int v = dislike[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        int[] colors = new int[n+1];
        Arrays.fill(colors,-1);

        for(int j =1; j<colors.length; j++){
            if(colors[j] == -1){
                dfs(graph,j,colors,0);
            }
        }
        return res;
    }
    void dfs( ArrayList<Integer>[] graph, int node, int[] colors,int c){
        colors[node] = c;

        for(int i =0; i<graph[node].size(); i++){
            int neigh = graph[node].get(i);

            if(colors[neigh] != -1 && colors[neigh] == c){
                res =  false;
            }
            if(colors[neigh] == -1){
                dfs(graph,neigh,colors,1-c);
            }
        }
    }
}