class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] zeroRows = new boolean[rows];
        boolean[] zeroCols = new boolean[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    zeroRows[i] = true;
                    zeroCols[j] = true;
                }
            }
        }
        for(int i=0;i<rows;i++){
            if(zeroRows[i]==true){
                for(int j=0;j<cols;j++){
                    matrix[i][j]=0;
                }
            }
            
        }
        for(int i=0;i<cols;i++){
            if(zeroCols[i]==true){
                for(int j=0;j<rows;j++){
                    matrix[j][i]=0;
                }
            }
            
        }

        
    }
}