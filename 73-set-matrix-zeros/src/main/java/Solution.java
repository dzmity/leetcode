class Solution {
    // Requirement - constant space solution
    public void setZeroes(int[][] matrix) {
        // use first row = 0 and column = 0 for storing zero info
        boolean zeroRowShouldBeReplaced = false;
        boolean zeroColumnShouldBeReplaced = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0 && !zeroRowShouldBeReplaced) {
                        zeroRowShouldBeReplaced = true;
                    }
                    if (j == 0 && !zeroColumnShouldBeReplaced) {
                        zeroColumnShouldBeReplaced = true;
                    }
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (zeroRowShouldBeReplaced) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }

        if (zeroColumnShouldBeReplaced) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}