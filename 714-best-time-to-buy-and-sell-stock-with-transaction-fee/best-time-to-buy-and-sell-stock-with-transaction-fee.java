class Solution {
    public int maxProfit(int[] prices, int fee) {
         int oldBuyStateProfit = -prices[0];
        int oldSellStateProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            int newBuyStateProfit = Math.max(oldSellStateProfit - prices[i],oldBuyStateProfit);
            int newSellStateProfit = Math.max(oldBuyStateProfit + prices[i] - fee, oldSellStateProfit);
            
            oldBuyStateProfit = newBuyStateProfit;
            oldSellStateProfit = newSellStateProfit;
        }
        return oldSellStateProfit;
    }
}