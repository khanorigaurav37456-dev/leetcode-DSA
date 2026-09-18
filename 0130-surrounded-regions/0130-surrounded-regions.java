class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int a =0; a<n; a++){
            for(int b = 0; b<m; b++){
                if(board[a][b] == 'O' && (a == 0 || a == n-1 || b== 0 || b == m-1)){
                    dfs(board,n,m,a,b);
                }
            }
        }
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }
        
    }
    boolean valid(int n, int m,int i,int j){
        return i >= 0 && i <n && j >=0 && j<m;
    }
    
    void dfs(char[][] board,int n,int m, int i, int j){
        board[i][j] = '#';

        for(int k =0; k<4; k++){
            int row = i + x[k];
            int col = j + y[k];

            if(valid(n,m,row,col) && board[row][col] == 'O'){
                dfs(board,n,m,row,col);
            }
        }
    }
}