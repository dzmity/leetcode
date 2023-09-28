import java.util.HashSet;
import java.util.Set;

class Solution {

    private static final char O_SYMBOL = 'O';
    private static final char X_SYMBOL = 'X';

    public void solve(char[][] board) {

        Set<Pair> nodesNotToFlip = new HashSet<>();

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
                if (board[i][j] == O_SYMBOL && !nodesNotToFlip.contains(new Pair(i, j))) {
                    board[i][j] = X_SYMBOL;
                }
            }
        }
    }

    private void findRegion(char[][] board, int i, int j, Set<Pair> nodesNotToFlip) {
        if (board[i][j] == O_SYMBOL) {
            Pair potentialRoot = new Pair(i, j);
            if (!nodesNotToFlip.contains(potentialRoot)) {
                bfs(board, nodesNotToFlip, i, j, board.length, board[i].length);
            }
        }
    }

    private void bfs(
            char[][] board,
            Set<Pair> nodesNotToFlip,
            int i,
            int j,
            int m,
            int n) {

        if (i >= m || i < 0 || j >= n || j < 0 || board[i][j] != O_SYMBOL) {
            return;
        }

        Pair pair = new Pair(i, j);
        if (!nodesNotToFlip.contains(pair)) {
            nodesNotToFlip.add(pair);
            bfs(board, nodesNotToFlip, i, j + 1, m, n);
            bfs(board, nodesNotToFlip, i, j - 1, m, n);
            bfs(board, nodesNotToFlip, i + 1, j, m, n);
            bfs(board, nodesNotToFlip, i - 1, j, m, n);
        }
    }

    public class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (i != pair.i) return false;
            return j == pair.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }
}
