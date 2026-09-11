class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int fresh = 0;
        int time = 0;

        for(int i= 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                    grid[i][j] = -2;
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }}
                while(!queue.isEmpty() && fresh > 0){
                    time++;
                    int s = queue.size();

                    while(s>0){
                        int[] current = queue.poll();
                        int r = current[0];
                        int c = current[1];

                        for(int a = 0; a < 4; a++){
                            int row = r + x[a];
                            int col = c + y[a];

                            if(valid(row,col,n,m) && grid[row][col] == 1){
                                queue.offer(new int[]{row,col});
                                grid[row][col] = -2;
                                fresh--;
                            }
                        }
                        s--;
                    }
                }
            
        if(fresh > 0){
            return -1;
        } else{
            return time;
        }
    }
    boolean valid(int i, int j, int n, int m){
        return i >= 0 && i < n && j >= 0 && j < m;   
    }
}