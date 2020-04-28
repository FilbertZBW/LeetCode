//322. Coin Change
//Classic Dynamic Programming Problem!
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        //dp function represents minimun coins 
        //that add up to each index. 
        int[] dp = new int[amount+1];
        dp[0] = 0;
        for(int i = 1; i <= amount; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int k = 0; k < n; k++){
                if(i >= coins[k] && dp[i-coins[k]] != Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i], dp[i-coins[k]]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1:dp[amount];
    }
}