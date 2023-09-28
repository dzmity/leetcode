import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    private static final char LAND = '1';

    public int numIslands(char[][] grid) {

        Map<Pair, Pair> rootByLand = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == LAND) {
                    Pair potentialRoot = new Pair(i, j);
                    if (!rootByLand.containsKey(potentialRoot)) {
                        bfs(grid, potentialRoot, rootByLand, i, j, grid.length, grid[i].length);
                    }
                }
            }
        }
        return new HashSet<>(rootByLand.values()).size();
    }

    private void bfs(
            char[][] grid,
            Pair currentRoot,
            Map<Pair, Pair> rootByLand,
            int i,
            int j,
            int m,
            int n) {

        if (i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != LAND) {
            return;
        }

        Pair pair = new Pair(i, j);
        if (!rootByLand.containsKey(pair)) {
            rootByLand.put(pair, currentRoot);
            bfs(grid, currentRoot, rootByLand, i, j + 1, m, n);
            bfs(grid, currentRoot, rootByLand, i, j - 1, m, n);
            bfs(grid, currentRoot, rootByLand, i + 1, j, m, n);
            bfs(grid, currentRoot, rootByLand, i - 1, j, m, n);
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
