class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid2.length;
        int m = grid2[0].length;
        boolean result;
        int answer = 0;
        for(int a = 0; a<n; a++){
            for(int b = 0; b<m; b++){
                if(grid2[a][b]== 1){
                     result = dfs(grid1,grid2,a,b,n,m);
                     if (result){
                    answer++;
                }
                }
                
                
            }
        }
        return answer;
    }
    boolean valid(int n, int m,int i,int j){
        return i >= 0 && i <n && j >=0 && j<m;
    }
    boolean dfs(int[][] grid1, int[][] grid2, int i, int j,int n,int m){
        
        grid2[i][j] = 0;
        boolean endResult = grid1[i][j] == 1;

        
            for(int k =0; k<4; k++){
                int row = i + x[k];
                int col = j + y[k];

                if(valid(n,m,row,col) && grid2[row][col] == 1){
                    boolean result = dfs(grid1,grid2,row,col,n,m);
                    endResult = endResult && result;
                }
            }
        
        return endResult;
    }
}