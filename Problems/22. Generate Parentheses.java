class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, "", 0, 0, n);
        return res;
    }
    

    //Take care of the adding rule. Only when close < open can we add close.
    private void backtrack(List<String> res, String curr, int open, int close, int max){
        if(curr.length() == max * 2){
            res.add(curr);
        }
        
        if(open < max){
            backtrack(res, curr + "(", open+1, close, max);
        }
        
        if(close < open){
            backtrack(res, curr + ")", open, close+1, max);
        }
    }
}