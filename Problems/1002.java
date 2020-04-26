//1002. Find Common Characters

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> ans = new ArrayList<>();
        //minimum frequency of chars in all words
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        
        for(String word : A){
       		//for each word in A, create a frequency list 
       		//for comparison with minFreq
            int[] freq = new int[26];

            //A brilliant way using relative shifting
            //given the fact that all are lowercase letters
            for(char c : word.toCharArray()){
                freq[c - 'a']++;
            }

            //update minFreq
            for(int i = 0; i < 26; i++){
                minFreq[i] = Math.min(freq[i], minFreq[i]);
            }
        }
        
        //add chars to the result list based on minFreq
        for(int i = 0; i < 26; i++){
            while(minFreq[i] > 0){
                ans.add("" + (char)('a' + i));
                minFreq[i]--;
            }
        }
        return ans;
    }
}