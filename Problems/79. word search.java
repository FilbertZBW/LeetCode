class Solution {
    public boolean exist(char[][] board, String word) {
        //Goal: Find a sequence of characters in board that spells put the given word.
        //General approach: Explore the board like graph traversal
        //Constrains: Cannot use the same cell more than once.
        
        
        //record the status of cells
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, board, word, 0, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    
    private boolean dfs(int i, int j, char[][] board, String word, int index, boolean[][] visited){
        //base case: We have already finished exploring
        if(index == word.length()){
            return true;
        }
        
        //if index out of bound, we can stop and return false immediately
        if(i < 0 || i == board.length || j < 0 || j == board[0].length){
            return false;
        }
        
        //For the current index, tell whether the corresponding letter is equal to what we are exploring on board
        //If so, mark current position as true and continue exploring. After finishing exploring the current, 
        //remember to reset the visit status for the succeeding calls.
        char character = word.charAt(index);
        if(character == board[i][j] && !visited[i][j]){
            visited[i][j] = true;
            boolean result = dfs(i+1, j, board, word, index+1, visited) || dfs(i-1, j, board, word, index+1, visited) ||
                dfs(i, j+1, board, word, index+1, visited) || dfs(i, j-1, board, word, index+1, visited);
            visited[i][j] = false;
            return result;
        }else{
            return false;
        }
    }
}