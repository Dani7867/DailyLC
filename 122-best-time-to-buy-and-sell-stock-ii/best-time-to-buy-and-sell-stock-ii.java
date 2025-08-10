class Solution {
    public int maxProfit(int[] prices) {
        int bd = 0 , sd = 0 , profit = 0 ;
        for(int i = 1 ; i < prices.length ; i++){
            if(prices[i] > prices[i-1]){
                sd = i;
            }else{
                profit += prices[sd] - prices[bd];
                bd = sd = i;
            }
        }
        profit += prices[sd] - prices[bd];
        return profit;
    }
}