class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0){
            return new int[0];
        }
        
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        int k = 0;
        int r;
        int c;
        //We have to go over all the elements in the first row and 
        //last col to cover all possible diagonals
        for(int i = 0; i < row + col - 1; i++){
            List<Integer> intermediate = new ArrayList<>();
            if(i < col){
                r = 0;
                c = i;
            }else{
                r = i - col + 1;
                c = col - 1;
            }
            
            while(r < row && c > -1){
                intermediate.add(matrix[r][c]);
                r++;
                c--;
            }
            
            if(i % 2 == 0){
                Collections.reverse(intermediate);
            }
            
            for(int j = 0; j < intermediate.size(); j++){
                res[k] = intermediate.get(j);
                k++;
            }
        }
        
        
        return res;
        
    }
}