class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    int max = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int a = 0; a<n; a++){
            for(int b = 0; b<m; b++){
                if(grid[a][b] == 1){
                    max = Math.max(dfs(grid,a,b,n,m),max);
                }
            }
        }
        return max;

    }
    boolean valid(int n, int m,int i,int j){
        return i >= 0 && i <n && j >=0 && j<m;
    }
    int dfs(int[][] grid, int i, int j,int n, int m){
        grid[i][j] = 0;
        int area = 1;

        for(int k =0; k<4; k++){
            int row = i + x[k];
            int col = j + y[k];

            if(valid(n,m,row,col) && grid[row][col] == 1){
                area += dfs(grid,row,col,n,m);
            }
        }
        return area;
    }
}
