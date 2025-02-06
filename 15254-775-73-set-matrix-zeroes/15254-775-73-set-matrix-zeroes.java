class Solution {
    public int[][] setZeroes(int[][] matrix) {
        
        HashSet<Integer> row_set = new HashSet<>();
        HashSet<Integer> column_set = new HashSet<>();

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(matrix[i][j]==0){
                    row_set.add(i);
                    column_set.add(j);
                }
            }
        }

        for(int num : row_set){
            for(int j=0; j<matrix[0].length; j++){
                matrix[num][j] = 0;
            }
        }

        for(int num : column_set){
            for(int i=0; i<matrix.length; i++){
                matrix[i][num] = 0;
            }
        }

        return matrix;
    }
}