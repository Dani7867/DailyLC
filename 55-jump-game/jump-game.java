class Solution {
    public boolean canJump(int[] jumps) {
         int n = jumps.length;
        Integer[] dp = new Integer[n];  // Use Integer to allow null values
        dp[n - 1] = 0; // Base case: 0 steps needed from end to end

        for (int i = n - 2; i >= 0; i--) {
                int steps = jumps[i];
                int minSteps = Integer.MAX_VALUE;
                for (int j = 1; j <= steps && i + j < n; j++) {
                    if (dp[i + j] != null && dp[i+j] < minSteps) {
                        minSteps =  dp[i + j];
                    }
                }

                if (minSteps != Integer.MAX_VALUE) {
                    dp[i] = 1 + minSteps;
                }
            }
        

        return dp[0] != null ? true : false;
    }
}