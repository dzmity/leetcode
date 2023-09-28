class Solution2 {

    private static final char O_SYMBOL = 'O';
    private static final char X_SYMBOL = 'X';

    public void solve(char[][] board) {

        int[][] nodesNotToFlip = new int[board.length][board[0].length];

        // top border
        for (int j = 0; j < board[0].length; j++) {
            findRegion(board, 0, j, nodesNotToFlip);
        }
        // bottom border
        for (int j = 0; j < board[0].length; j++) {
            findRegion(board, board.length - 1, j, nodesNotToFlip);
        }
        // left border
        for (int i = 0; i < board.length; i++) {
            findRegion(board, i, 0, nodesNotToFlip);
        }
        // right border
        for (int i = 0; i < board.length; i++) {
            findRegion(board, i, board[0].length - 1, nodesNotToFlip);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == O_SYMBOL && nodesNotToFlip[i][j] == 0) {
                    board[i][j] = X_SYMBOL;
                }
            }
        }
    }

    private void findRegion(char[][] board, int i, int j, int[][] nodesNotToFlip) {
        if (board[i][j] == O_SYMBOL) {
            if (nodesNotToFlip[i][j] == 0) {
                bfs(board, nodesNotToFlip, i, j);
            }
        }
    }

    private void bfs(char[][] board, int[][] nodesNotToFlip, int i, int j) {

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != O_SYMBOL) {
            return;
        }

        if (nodesNotToFlip[i][j] == 0) {
            nodesNotToFlip[i][j] = 1;
            bfs(board, nodesNotToFlip, i, j + 1);
            bfs(board, nodesNotToFlip, i, j - 1);
            bfs(board, nodesNotToFlip, i + 1, j);
            bfs(board, nodesNotToFlip, i - 1, j);
        }
    }
}
