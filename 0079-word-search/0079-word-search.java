class Solution {
    public boolean exist(char[][] board, String word) {
        for(int row = 0; row<board.length; row++){
            for(int col = 0; col<board[0].length; col++){
                if(search(board,row,col,word,0)){
                return true;
                }
            }
        }
        return false;
    }
    boolean search(char[][] board, int row, int col, String word, int index){
        //entire word matched

        if(index == word.length()){
            return true;
        }
        //boundary check
        if(row<0 || col<0 || row>= board.length || col>= board[0].length){
            return false;
        }
        //character mismatch
        if(board[row][col] != word.charAt(index)){
            return false;
        }
        //backtracking
        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = 
        search(board,row-1,col,word,index+1) || //up
        search(board,row+1,col,word,index+1) || // bottom
        search(board,row,col-1,word,index+1) || // left
        search(board,row,col+1,word,index+1);   // right
        board[row][col] = temp;
        return found;
    }
    
}