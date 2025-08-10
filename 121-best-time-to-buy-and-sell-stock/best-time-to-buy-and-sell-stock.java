class Solution {
    public int maxProfit(int[] prices) {
        int leastSoFar = Integer.MAX_VALUE;
        int profitToday = 0;
        int maxProfit = Integer.MIN_VALUE;

        for(int p : prices){
            if(p<leastSoFar){
                leastSoFar = p;
            }

            profitToday = p - leastSoFar;

            if(profitToday>maxProfit){
                maxProfit = profitToday;
            }
        }
        return maxProfit;
    }
}