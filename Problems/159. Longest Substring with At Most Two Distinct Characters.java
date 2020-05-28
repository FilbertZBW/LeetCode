//Use set to track existing chars and number of unique chars. Should be a quite simple one.

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0 || s.length() == 1){
            return s.length();
        }
        
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            int count = 0;
            Set<Character> set = new HashSet<>();
            for(int j = i; j < s.length(); j++){
                if(set.contains(s.charAt(j))){
                    count++;
                    max = Math.max(max, count);
                }else{
                    if(set.size() == 2){
                        max = Math.max(max, count);
                        break;
                    }
                    set.add(s.charAt(j));
                    count++;
                    max = Math.max(max, count);
                }
            }
            
        }
        return max;
    }
}