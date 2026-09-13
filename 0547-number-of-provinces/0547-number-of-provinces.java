class Solution {
    public int findCircleNum(int[][] isConnected) {
       int n = isConnected.length;
       int provinces = 0;
       boolean[] visited = new boolean[n];

       for(int city =0; city <n; city++){
        if(!visited[city]){
            provinces++;
            dfs(city,isConnected,n,visited);
        }
       }
       return provinces; 
    }
    void dfs(int city, int[][] isConnected,int n,boolean[] visited){
        visited[city] = true;

        for(int j =0; j<n; j++){
            if(isConnected[city][j] == 1 && !visited[j]){
                dfs(j,isConnected,n,visited);
            }
        }
    }
}