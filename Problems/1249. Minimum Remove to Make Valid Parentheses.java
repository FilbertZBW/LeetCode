class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] c = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        
        //Keep track of the num of parenthesis added to sb
        for(int i = 0; i < c.length; i++){
            if(c[i] == '('){
                left++;
            }else if(c[i] == ')'){
                right++;
                if(right > left){
                    right--;
                    continue;
                }
            }
            
            sb.append(c[i]);
        }
        
        //Remove redundant '('
        StringBuilder res = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0; i--){
            if(sb.charAt(i) == '(' && left > right){
                left--;
                continue;
            }
            res.append(sb.charAt(i));
        }
        
        return res.reverse().toString();
    }
}