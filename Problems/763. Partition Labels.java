class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] ends = new int[26];
        
        //Mark the ending position for all characters in S
        for(int i = 0; i < S.length(); i++){
            if(i > ends[S.charAt(i) - 'a']){
                ends[S.charAt(i) - 'a'] = i;
            }
        }
        
        //
        int i = 0;
        while(i < S.length()){
            int end = ends[S.charAt(i) - 'a'];  //ending position of current char
            int j = i;                          //Second pointer
            while(j != end){                    //Move second pointer and j simutaneously
                end = Math.max(end, ends[S.charAt(j) - 'a']);
                j++;
            }
            res.add(j - i + 1);
            i = j + 1;
        }
        
        return res;
    }
}