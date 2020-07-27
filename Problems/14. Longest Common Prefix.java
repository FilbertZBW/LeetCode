class Solution {
    //Know what prefix means? It'll make things much easier.
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){ //contains different chars that previous string does not have
                prefix = prefix.substring(0, prefix.length() - 1); //shrink the string
                if(prefix.isEmpty()){ //no common prefix with the prev str
                    return "";
                }
            }
        }
        
        return prefix;
    }
}