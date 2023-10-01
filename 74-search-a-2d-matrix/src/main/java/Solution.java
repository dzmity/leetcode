class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int minValue = matrix[0][0];
        int maxValue = matrix[m - 1][n - 1];

        if (target < minValue || target > maxValue) {
            return false;
        }

        int row = findRow(0, m - 1, target, matrix);
        return columnExists(0, n - 1, target, matrix[row]);
    }

    private int findRow(int startIndexIncl, int endIndexIncl, int target, int[][] matrix) {
        int n = matrix[0].length;
        int midIndex = (startIndexIncl + endIndexIncl) / 2;

        boolean rowWithValuesMoreThanTarget = matrix[midIndex][n - 1] >= target;
        boolean previousRowWithValuesLessThanTarget = midIndex == 0 || matrix[midIndex - 1][n - 1] < target;

        if (rowWithValuesMoreThanTarget && previousRowWithValuesLessThanTarget) {
            return midIndex;
        } else if (rowWithValuesMoreThanTarget) {
            return findRow(startIndexIncl, midIndex - 1, target, matrix);
        } else {
            return findRow(midIndex + 1, endIndexIncl, target, matrix);
        }
    }

    private boolean columnExists(int start, int end, int target, int[] array) {
        if (end < start) {
            return false;
        }
        int midIndex = (start + end) / 2;
        int value = array[midIndex];

        if (value == target) {
            return true;
        }

        if (value > target) {
            return columnExists(start, midIndex - 1, target, array);
        }

        return columnExists(midIndex + 1, end, target, array);
    }
}