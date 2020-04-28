//1010. Pairs of Songs With Total Durations Divisible by 60
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
    	//edge cases
        if(time == null || time.length < 2){
            return 0;
        }
        int res = 0;
       
        //store number of pairs when traversing each duration
        int[] count = new int[60];

        for(int t : time){

        	//store the remainder that less than 60
            int remainder = t % 60;

            //avoid indexOutOfBound
            if(remainder == 0){
                res += count[0];
            }else{
                res += count[60 - remainder];
            }

            //add number of pairs to count
            //note: # of pairs = 1+2+3+...+(# of remainders - 1)
            //reason: when you add new element, it can form 
            //pairs with all existing elements.
            
            count[remainder]++;
        }
        
        return res;
    }
}