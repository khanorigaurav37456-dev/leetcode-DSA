class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] board = new boolean[n][n];
        backtrack(board, 0, result);
        return result;
    }

    private void backtrack(boolean[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            result.add(construct(board));   // CHOOSE was already done by caller — this just records it
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;          // CHOOSE
                backtrack(board, row + 1, result); // EXPLORE
                board[row][col] = false;         // UN-CHOOSE
            }
        }
    }

    private List<String> construct(boolean[][] board) {
        List<String> oneSolution = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean cell : row) {
                sb.append(cell ? 'Q' : '.');
            }
            oneSolution.add(sb.toString());
        }
        return oneSolution;
    }

    private boolean isSafe(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        int maxleft = Math.min(row, col);
        for (int i = 1; i <= maxleft; i++) {
            if (board[row - i][col - i]) return false;
        }
        int maxright = Math.min(row, board.length - col - 1);
        for (int i = 1; i <= maxright; i++) {
            if (board[row - i][col + i]) return false;
        }
        return true;
    }
}