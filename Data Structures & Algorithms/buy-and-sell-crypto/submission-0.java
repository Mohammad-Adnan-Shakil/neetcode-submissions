class Solution {
    public int maxProfit(int[] prices) {
        int left = prices[0];
        int profit = 0;

        for(int i = 1; i < prices.length; i++){
            if(prices[i] < left){
                left = prices[i];
            }
            profit = Math.max(profit, prices[i] - left);
        }
        return profit;
    }
}