//Algorithm: check bulls first, then cows
//create two arrays for checking the number of cows
//(the index of array represents the figure and its element represents its frequency)

class Solution {
    public String getHint(String secret, String guess) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        int numBull = 0;
        int numCow = 0;
        
        for(int i = 0; i < secret.length(); i++){
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if(c1 == c2){
                numBull++;
            }else{
                arr1[c1 - '0']++;
                arr2[c2 - '0']++;
            }
        }
        
        for(int i = 0; i < 10; i++){
            numCow += Math.min(arr1[i], arr2[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(numBull);
        sb.append('A');
        sb.append(numCow);
        sb.append('B');
        return sb.toString();
    }
}