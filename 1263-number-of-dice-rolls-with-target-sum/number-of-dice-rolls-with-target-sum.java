import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    Integer[][] memo;

    public int numRollsToTarget(int n, int k, int target) {
        memo = new Integer[n + 1][target + 1];  // Memoization table
        return helper(n, k, target);
    }

    private int helper(int n, int k, int target) {
        if (target < 0) return 0;  // Invalid case: negative target
        if (n == 0) return target == 0 ? 1 : 0;  // Base case: all dice used

        if (memo[n][target] != null) return memo[n][target];  // Return cached result

        long ways = 0;
        for (int i = 1; i <= k; i++) {  // Try each face value of the dice
            ways = (ways + helper(n - 1, k, target - i)) % MOD;
        }

        return memo[n][target] = (int) ways;  // Store and return result
    }
}
