class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] distance = new int[n][m];
        for(int i= 0; i<n; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        distance[0][0]= grid[0][0];
        heap.offer(new int[]{grid[0][0], 0 ,0});
        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int currentTime = current[0];
            int row = current[1];
            int col = current[2];
            for(int i= 0; i<4; i++){
                int r = row + x[i];
                int c = col + y[i];
                if(!valid(n,m,r,c)){
                    continue;
                }
                int max = Math.max(currentTime,grid[r][c]);
                if(max < distance[r][c]){
                    distance[r][c] = max;
                    heap.offer(new int[]{max,r,c});
                }
            }
        }
        return distance[n-1][m-1];
    }
    boolean valid(int n, int m,int i,int j){
        return i >= 0 && i <n && j >=0 && j<m;
    }
}