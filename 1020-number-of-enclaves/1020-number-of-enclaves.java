class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int answer = 0;

        for(int a = 0; a<n; a++){
            for(int b = 0; b<m; b++){
                if(grid[a][b] == 1 &&(a == 0 || a == n - 1 || b == 0 || b == m - 1)){
                    dfs(grid,a,b,n,m);
                }
            }
        }
        for(int a =0; a<n; a++){
            for(int b =0; b<m; b++){
                if(grid[a][b] == 1){
                    answer++;
                }
            }
        }
        return answer;


    }
    boolean valid(int n, int m,int i,int j){
        return i >= 0 && i <n && j >=0 && j<m;
    }

    void dfs(int[][] grid,int i, int j,int n, int m){
        grid[i][j] = 0;

        for(int k =0; k<4; k++){
            int row = i + x[k];
            int col = j + y[k];

            if(valid(n,m,row,col) &&grid[row][col] == 1){
                dfs(grid,row,col,n,m);
            }
        }
    }
}