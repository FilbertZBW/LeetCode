#Sum of Even Numbers After Queries
class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        
        //initialize the sum
        int sum = 0;
        for(int x : A){
            if(x % 2 == 0){
                sum += x;
            }
        }
    
        
        for(int i = 0; i < queries.length; i++){
            int val = queries[i][0];
            int index = queries[i][1];
            //if A[index] is even, then remove it and see how it changes after adding
            //if A[index] is odd, then it does not count to the sum inherently so skip.
            if(A[index] % 2 == 0){
                sum -= A[index];
            }
            A[index] += val;
            
            //if now A[index] is even, update sum.
            if(A[index] % 2 == 0){
                sum += A[index];
            }
            ans[i] = sum;
        }
        
        return ans;
    }
}