//mapping is the key! We create a virtual keyboard 
by mapping keys to letters in an array

class Solution {
    public List<String> letterCombinations(String digits) { 
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return res;
        }
        String[] mapping = new String[]{
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        backtrack(mapping, res, digits, "", 0);
        return res;
    }
    
    private void backtrack(String[] mapping, List<String> res, String digits, String current, int index){
        if(index == digits.length()){
            res.add(current);
            return;
        }
        
        String letters = mapping[digits.charAt(index) - '0'];

        for(int i = 0; i < letters.length(); i++){
            backtrack(mapping, res, digits, current + letters.charAt(i), index+1);
        }
    }
}