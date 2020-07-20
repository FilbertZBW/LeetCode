class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        
        int start = 0;
        int end = 0;
        
        for(int i = 0; i < s.length(); i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > end - start){
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }
        
        return s.substring(start, end + 1);
        
    }
    
    public int expand(String s, int left, int right){
        if(s == null || left > right){
            return 0;
        }
        
        while(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))){
            left--;
            right++;
        }
        
        //Since we expanded one more time for left and right(in the last loop),
        //it actually should be (right-1) - (left+1) + 1 = right - left - 1.
        return right - left - 1;
    }
}