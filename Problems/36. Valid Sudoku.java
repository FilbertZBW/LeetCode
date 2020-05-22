//A really really brilliant way of solving!
//the process is just like you are filling the sudoku. 
//For each element, fill in its status in terms of row, col and grid
//respectively. If the current is duplicate with previously filled elements
//in terms of any state, the size of the set will not be equal to the number
//of elements*3(since each element has 3 states).

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //Divide boxes and lines
        //put them in sets
        //check set size
        int count = 0;
        Set<String> seen = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    seen.add(board[i][j] + "seen in row" + i);
                    seen.add(board[i][j] + "seen in col" + j);
                    seen.add(board[i][j] + "seen in grid" + i/3 + "-" + j/3);
                    count++;
                }
            }
        }
        return seen.size() == 3*count;
    }
}