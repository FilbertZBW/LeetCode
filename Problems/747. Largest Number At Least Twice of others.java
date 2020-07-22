//Save largest number and its index, then
//loop the array, skip the largest and check whether
//there exists a number greater than max/2.

class Solution {
    public int dominantIndex(int[] nums) {
        int max_index = 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > max){
                max_index = i;
                max = nums[i];
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(i == max_index){
                continue;
            }else{
                if(nums[i] > max/2){
                    return -1;
                }
            }
        }
        return max_index;
    }
}