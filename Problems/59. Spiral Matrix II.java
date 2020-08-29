class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int num = 1;
        
        while(num <= n*n){
            //left to right
            for(int i = l; i <= r; i++){
                matrix[l][i] = num;
                num++;
            }
            t++;
            
            //top to bottom
            for(int i = t; i <= b; i++){
                matrix[i][r] = num;
                num++;
            }
            r--;
            
            //right to left
            for(int i = r; i >= l; i--){
                matrix[b][i] = num;
                num++;
            }
            b--;
            
            //bottom to top
            for(int i = b; i >= t; i--){
                matrix[i][l] = num;
                num++;
            }
            l++;
        }
        
        return matrix;
    }
}