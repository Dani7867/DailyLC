class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[k+1][n];

        for (int i = 1; i <= k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < n; j++) {
                max = Math.max(dp[i-1][j-1]  - prices[j-1],max);
                dp[i][j] = Math.max(max + prices[j],dp[i][j-1]);
            }
        }

        return dp[k][n-1];
    }
}