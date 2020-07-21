//the longest increasing subsequence possible upto the ith index 
//in a given array is independent of the elements coming later on in the array

class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }

        //dp[i] represents the length of the longest increasing subsequence possible 
        //considering the array elements upto the ith index only
        //Check every element before current one and find the largest dp[j]
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for(int i = 1; i < dp.length; i++){
            int maxval = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        
        return maxans;
    }
}