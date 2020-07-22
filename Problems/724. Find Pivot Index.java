//Update leftSum everytime and check whether it is equal to rightSum
//Like a dynamic programming but no need to create a dp array.

class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for(int i:nums){
            sum += i;
        }
        for(int i = 0; i < nums.length; i++){
            if(leftSum == sum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}