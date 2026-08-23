class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->{
           return Integer.compare(
                matrix[a[0]][a[1]],
                matrix[b[0]][b[1]]
            );
        });

        for(int row = 0; row<matrix.length; row++){
            minHeap.offer(new int[]{row,0});
        }
        int answer = 0;
        for(int i=0; i<k; i++){
        int[] current = minHeap.poll();
        int row = current[0];
        int col = current[1];
        answer = matrix[row][col];

        if(col + 1 < matrix[0].length){
        minHeap.offer(new int[]{row,col + 1});
        }
        }
        return answer;
    }
}