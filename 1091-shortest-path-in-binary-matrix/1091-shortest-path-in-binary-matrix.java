class Solution {
    int[] x = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] y = {-1,  0,  1,-1, 1,-1, 0, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int path = 1;

        Queue<int[]> queue = new LinkedList<>();
        if(grid[0][0] == 1){
            return -1;
        }
        if(m ==1 && n == 1){
            return 1;
        }
        
        if(grid[m-1][n-1] == 1){
            return -1;
        }
        queue.offer(new int[]{0,0});
        grid[0][0] = 1;

        while(!queue.isEmpty()){
            int size= queue.size();

            for(int level = 0; level<size; level++){
                int[] arr = queue.poll();
                int row = arr[0];
                int col = arr[1];

                for(int i=0; i<8; i++){
                    int r = row + x[i];
                    int c = col + y[i];

                    if(valid(m,n,r,c) && grid[r][c] == 0){
                        if(r == m-1 && c == n-1){
                            return path + 1;
                        }
                        grid[r][c] = 1;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            path++;
        }
        return -1;
    }
      boolean valid(int m, int n,int i,int j){
        return i >= 0 && i <m && j >=0 && j<n;
    }
}