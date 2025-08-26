class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            char prev = s.charAt(i - 1);
            char curr = s.charAt(i);

            if (prev == '0' && curr == '0') {
                dp[i] = 0;
            } else if (prev == '0' && curr != '0') {
                dp[i] = dp[i - 1];
            } else if (prev != '0' && curr == '0') {
                if (prev == '1' || prev == '2') {
                    dp[i] = i >= 2 ? dp[i - 2] : 1;
                } else {
                    dp[i] = 0;
                }
            } else {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                if (num <= 26) {
                    dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
                } else {
                    dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length() - 1];
    }
}
