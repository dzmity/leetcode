import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    private static final char EMPTY_ELEMENT = '.';
    private static final int COLUMN_COUNT = 9;
    private static final int SQUARE_SIZE = 3;

    public boolean isValidSudoku(char[][] board) {

        List<Set<Character>> columns = new ArrayList<>();
        for (int i = 0; i < COLUMN_COUNT; i++) {
            columns.add(new HashSet<>());
        }

        int startRow = 0;
        int endRow = SQUARE_SIZE;
        int rowSquareIndex = 0;
        while (rowSquareIndex < SQUARE_SIZE) {

            List<Set<Character>> squares = new ArrayList<>();
            List<Set<Character>> rows = new ArrayList<>();
            for (int k = 0; k < SQUARE_SIZE; k++) {
                squares.add(new HashSet<>());
                rows.add(new HashSet<>());
            }

            for (int rowIndex = startRow; rowIndex < endRow; rowIndex++) {

                int startColumn = 0;
                int endColumn = SQUARE_SIZE;
                int squareIndex = 0;

                while (squareIndex < SQUARE_SIZE) {
                    for (int columnIndex = startColumn; columnIndex < endColumn; columnIndex++) {
                        char element = board[rowIndex][columnIndex];
                        if (element != EMPTY_ELEMENT) {
                            if (!columns.get(columnIndex).add(element)
                                    || !rows.get(rowIndex % SQUARE_SIZE).add(element)
                                    || !squares.get(squareIndex).add(element)) {
                                return false;
                            }
                        }
                    }
                    startColumn += SQUARE_SIZE;
                    endColumn += SQUARE_SIZE;
                    squareIndex++;
                }
            }

            startRow += SQUARE_SIZE;
            endRow += SQUARE_SIZE;
            rowSquareIndex++;
        }
        return true;
    }
}
