class Solution {
    int[] x = {-1,1,0,0};
    int[] y = {0,0,-1,1};
    int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        originalColor = image[sr][sc];

        if(originalColor == color){
            return image;
        }
        int n = image.length;
        int m = image[0].length;
        dfs(image,n,m,sr,sc,color);
        return image;
    }
    boolean valid(int[][] image, int n, int m,int sr,int sc){
        return sr >= 0 && sr <n && sc >=0 && sc<m;
    }
    void dfs(int[][] image,int n, int m,int sr,int sc,int color){
        image[sr][sc] = color;

        for(int i =0; i<4; i++){
            int row = sr + x[i];
            int col = sc + y[i];

            if(valid(image,n,m,row,col) && image[row][col] == originalColor){
                dfs(image,n,m,row,col,color);
            }
        }
    }
}