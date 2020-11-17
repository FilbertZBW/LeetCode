class Solution {
    public int findCircleNum(int[][] M) {
        int res = 0;
        int n = M.length; //num of students
        int[] visited = new int[n];
        
        for(int i = 0; i < n; i++){
            if(visited[i] == 1){
                continue;
            }
            dfs(visited, i, M, n);
            res++;
        }
        
        return res;
    }
    
    private void dfs(int[] visited, int curr,int[][] M, int n){
        if(visited[curr] == 1){
            return;
        }
        
        visited[curr] = 1; 
        for(int i = 0; i < n; i++){
            if(M[i][curr] == 1 && visited[i] == 0){ //if i and curr has a friend relation
                dfs(visited, i, M, n);    
            }
        }
    }
}