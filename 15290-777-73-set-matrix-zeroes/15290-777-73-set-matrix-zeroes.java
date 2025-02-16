class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> column_set = new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {
            boolean rowHasZero = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowHasZero = true;
                    column_set.add(j);
                }
            }
            if (rowHasZero) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int col : column_set) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
            }
        }
    }
}
