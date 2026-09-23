class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] res = new int[n][m];

        for(int i= 0; i<n; i++){
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        res[0][0] = 0;
        heap.offer(new int[]{0,0,0});

        while(!heap.isEmpty()){
            int[] current = heap.poll();
            int distance = current[0];
            int row = current[1];
            int col = current[2];

            if(distance > res[row][col]){
                continue;
            }
            for(int j =0; j<4; j++){
                int r = row + x[j];
                int c = col + y[j];
                if(!valid(n,m,r,c)){
                    continue;
                }
                    int abs = Math.abs(heights[row][col] - heights[r][c]);
                    int newWeight = Math.max(abs,distance);

                    if(newWeight < res[r][c]){
                        res[r][c] = newWeight;
                        heap.offer(new int[]{newWeight, r,c});
                    }
            }
        }
        return res[n-1][m-1];
    }
    boolean valid(int n, int m,int i,int j){
        return i >= 0 && i <n && j >=0 && j<m;
    }
}