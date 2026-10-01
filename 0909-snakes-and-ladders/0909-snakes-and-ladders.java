class Solution {

    public int snakesAndLadders(int[][] board) {

        int n = board.length;

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n * n + 1];

        queue.offer(1);
        visited[1] = true;
        int rolls = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int current = queue.poll();
                if (current == n * n) {
                    return rolls;
                }
                for (int dice = 1; dice <= 6; dice++) {
                    int next = current + dice;
                    if (next > n * n) {
                        continue;
                    }
                    int row = n - 1 - (next - 1) / n;
                    int col = (next - 1) % n;

                    if ((n - 1 - row) % 2 == 1) {
                        col = n - 1 - col;
                    }
                    if (board[row][col] != -1) {
                        next = board[row][col];
                    }
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
                size--;
            }
            rolls++;
        }
        return -1;
    }
}