class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }else if(nums.length == 1){
            return nums[0];
        }
        
        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int res = maxSoFar;
        
        //Something like brute force to compare all possible combinations
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            
            //Change in maxSoFar can affect minSoFar! So using temp is necessary
            int tempMax = maxSoFar;
            int tempMin = minSoFar;
            maxSoFar = Math.max(curr, Math.max(tempMax * curr, tempMin * curr));
            minSoFar = Math.min(curr, Math.min(tempMax * curr, tempMin * curr));
            res = Math.max(res, maxSoFar);
        }
        
        return res;
    }
}