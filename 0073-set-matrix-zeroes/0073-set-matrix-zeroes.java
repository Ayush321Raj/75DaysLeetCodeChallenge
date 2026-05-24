class Solution {

    public void setZeroes(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check first row
        for (int c = 0; c < cols; c++) {

            if (matrix[0][c] == 0) {

                firstRowZero = true;
                break;
            }
        }

        // Check first column
        for (int r = 0; r < rows; r++) {

            if (matrix[r][0] == 0) {

                firstColZero = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int r = 1; r < rows; r++) {

            for (int c = 1; c < cols; c++) {

                if (matrix[r][c] == 0) {

                    matrix[r][0] = 0;
                    matrix[0][c] = 0;
                }
            }
        }

        // Set cells to zero using markers
        for (int r = 1; r < rows; r++) {

            for (int c = 1; c < cols; c++) {

                if (matrix[r][0] == 0 ||
                    matrix[0][c] == 0) {

                    matrix[r][c] = 0;
                }
            }
        }

        // Handle first row
        if (firstRowZero) {

            for (int c = 0; c < cols; c++) {

                matrix[0][c] = 0;
            }
        }

        // Handle first column
        if (firstColZero) {

            for (int r = 0; r < rows; r++) {

                matrix[r][0] = 0;
            }
        }
    }
}