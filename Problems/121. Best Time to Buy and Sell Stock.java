//121. Best Time to Buy and Sell Stock
class Solution {
    public int maxProfit(int[] prices) {
        //two pointers that indicate buy and sell position
        int buy = 0;
        int sell = 0;
        int max = 0;
        while(sell<prices.length){
        	//if sell<buy, it means there are lower price for buying, 
        	//which is a potential case for making more profits, 
        	//so move 'buy' pointer in this case.
        	//Remember to keep track of the max profit.
            if(prices[sell] < prices[buy]){
                buy = sell;
            }else{
                max = Math.max(max, prices[sell] - prices[buy]);
            }
            sell++;
        }
        return max;
    }
}