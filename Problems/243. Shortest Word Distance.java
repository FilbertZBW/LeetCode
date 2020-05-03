//brute force method and smarter method

class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
//         List<Integer> indexList1 = new ArrayList<>();
//         List<Integer> indexList2 = new ArrayList<>();
//         for(int i = 0; i < words.length; i++){
//             if(words[i].equals(word1)){
//                 indexList1.add(i);
//             }
//             if(words[i].equals(word2)){
//                 indexList2.add(i);
//             }
//         }
               
//         int res = Integer.MAX_VALUE;
//         for(int i = 0; i < indexList1.size(); i++){
//             int num1 = indexList1.get(i);
//             for(int j = 0; j < indexList2.size(); j++){
//                 int num2 = indexList2.get(j);
//                 res = Math.min(res, Math.abs(num1-num2));
//             }
//         }
//         return res;
        int i1 = -1, i2 = -1;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                i1 = i;
            }
            if(words[i].equals(word2)){
                i2 = i;
            }
            if(i1 != -1 && i2 != -1){
                res = Math.min(res, Math.abs(i1-i2));
            }     
        }
        
        return res; 
    }
}