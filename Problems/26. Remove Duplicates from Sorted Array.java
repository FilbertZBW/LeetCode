//slow always points to the position that a unique number should fill

class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 0;
        while(fast < nums.length){
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        
        return slow + 1;
    }
}