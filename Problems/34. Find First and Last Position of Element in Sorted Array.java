//Linear Scan. Easy to understand.
//Binary search gives a better runtime. Give it a try!

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == target){
                start = i;
                break;
            }
        }
        
      
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == target){
                end = i;
                break;
            }
        }
        
        return new int[]{start, end};
    }
}